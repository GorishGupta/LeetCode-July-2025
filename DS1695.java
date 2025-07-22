class DS1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10001];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < n; right++) {
            while (seen[nums[right]]) {
                currentSum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            currentSum += nums[right];
            seen[nums[right]] = true;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        DS1695 solution = new DS1695();
        int[] input = { 4, 2, 4, 5, 6 };
        int result = solution.maximumUniqueSubarray(input);
        System.out.println(result); // Output: 17
    }
}