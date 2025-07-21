public class DS1957 {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int freq = 1;
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev)
                freq++;
            else {
                prev = s.charAt(i);
                freq = 1;
            }
            if (freq < 3)
                res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DS1957 solution = new DS1957();
        String input = "leeetcode";
        String result = solution.makeFancyString(input);
        System.out.println(result); // Output: "leetcode"
    }
}
