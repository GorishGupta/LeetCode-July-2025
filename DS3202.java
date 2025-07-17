public class DS3202 {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int i = 0; i < k; i++) {
                dp[i][num] = dp[num][i] + 1;
                res = Math.max(res, dp[i][num]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DS3202 ds3202 = new DS3202();
        System.out.println(ds3202.maximumLength(new int[] { 1, 2, 3, 4, 5 }, 3)); // Output: 5
        System.out.println(ds3202.maximumLength(new int[] { 2, 4, 6 }, 2)); // Output: 3
        System.out.println(ds3202.maximumLength(new int[] { 1, 3, 5 }, 4)); // Output: 3
    }
}
