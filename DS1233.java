import java.util.*;

class DS1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = ans.get(ans.size() - 1) + "/";
            if (!folder[i].startsWith(lastFolder)) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DS1233 ds1233 = new DS1233();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        System.out.println(ds1233.removeSubfolders(nums));
    }
}