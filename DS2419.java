public class DS2419 {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < nums.length) {
            if (nums[j] == max) {
                ans = Math.max(j - i + 1, ans);
                j++;
            } else {

                j++;
                i = j;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        DS2419 ds = new DS2419();
        int[] nums = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 };
        System.out.println(ds.longestSubarray(nums));
        // Example output: 10
    }
}