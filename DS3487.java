import java.util.*;

class DS3487 {
    public int maxSum(int[] nums) {
        // Check if all elements are negative
        boolean allNegative = true;
        int maxValue = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= 0) {
                allNegative = false;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        if (allNegative)
            return maxValue;

        // Use a set to remove duplicates
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            unique.add(n);
        }

        // Sum all positive numbers from the set
        int sum = 0;
        for (int val : unique) {
            if (val > 0) {
                sum += val;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        DS3487 ds3487 = new DS3487();
        int[] nums = { -1, -2, -3, 4, 5, 4 };
        int result = ds3487.maxSum(nums);
        System.out.println("Maximum sum of unique positive integers: " + result);
    }
}
