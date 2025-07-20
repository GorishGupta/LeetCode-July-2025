import java.util.*;

public class DS1948 {

    class Node {
        Map<String, Node> subNodes = new TreeMap<>();
        String content = "";
        boolean remove = false;

        void markRemove() {
            if (remove)
                return;
            remove = true;
            for (Node child : subNodes.values()) {
                child.markRemove();
            }
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node();
        List<List<String>> result = new ArrayList<>();

        // Build the folder tree
        for (List<String> path : paths) {
            Node current = root;
            for (String folder : path) {
                current = current.subNodes.computeIfAbsent(folder, k -> new Node());
            }
        }

        // Post-order traversal to generate content hashes
        Map<String, Node> seen = new HashMap<>();
        serialize(root, seen);

        // Collect non-removed paths
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    // Serializes each node into a unique string representing its subtree
    private String serialize(Node node, Map<String, Node> seen) {
        if (node.subNodes.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Node> entry : node.subNodes.entrySet()) {
            String childName = entry.getKey();
            Node childNode = entry.getValue();
            String childContent = serialize(childNode, seen);
            sb.append(childName).append("{").append(childContent).append("}");
        }

        node.content = sb.toString();
        if (seen.containsKey(node.content)) {
            // Mark both current and previously seen node for removal
            node.markRemove();
            seen.get(node.content).markRemove();
        } else {
            seen.put(node.content, node);
        }

        return node.content;
    }

    // Collects all valid (non-removed) paths
    private void collectPaths(Node node, List<String> currentPath, List<List<String>> result) {
        for (Map.Entry<String, Node> entry : node.subNodes.entrySet()) {
            String folder = entry.getKey();
            Node child = entry.getValue();
            if (child.remove)
                continue;
            currentPath.add(folder);
            result.add(new ArrayList<>(currentPath));
            collectPaths(child, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    // Test driver
    public static void main(String[] args) {
        DS1948 ds1948 = new DS1948();
        List<List<String>> paths = new ArrayList<>();
        paths.add(List.of("a", "b", "c"));
        paths.add(List.of("a", "b", "c", "d"));
        paths.add(List.of("a", "b", "e"));
        paths.add(List.of("a", "f"));
        paths.add(List.of("g"));

        List<List<String>> result = ds1948.deleteDuplicateFolder(paths);
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}
