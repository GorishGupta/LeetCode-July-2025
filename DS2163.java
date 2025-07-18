import java.util.*;

public class DS2163 {
    public long minimumDifference(int[] nums) {

        long[] leftMins = new long[nums.length];
        long[] rightMaxs = new long[nums.length];

        int n = nums.length;
        int oneThird = n / 3;
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        long minSum = 0;
        long maxSum = 0;
        long ret = Long.MAX_VALUE;

        for (int i = 0; i < oneThird; i++) {
            pqMin.offer(nums[i]);
            minSum += nums[i];
        }
        leftMins[oneThird - 1] = minSum;

        for (int i = oneThird; i < n - oneThird; i++) {
            int x = nums[i];
            if (x < pqMin.peek()) {
                minSum += x - pqMin.poll();
                pqMin.offer(x);
            }

            leftMins[i] = minSum;
        }

        for (int i = n - 1; i >= n - oneThird; i--) {
            pqMax.offer(nums[i]);
            maxSum += nums[i];
        }
        rightMaxs[n - oneThird] = maxSum;

        for (int i = n - oneThird - 1; i >= oneThird - 1; i--) {
            int x = nums[i];
            if (x > pqMax.peek()) {
                maxSum += x - pqMax.poll();
                pqMax.offer(x);
            }

            rightMaxs[i] = maxSum;
        }

        for (int i = oneThird - 1; i < n - oneThird; i++) {
            ret = Math.min(ret, leftMins[i] - rightMaxs[i + 1]);
        }

        return ret;
    }

    public static void main(String[] args) {
        DS2163 ds2163 = new DS2163();
        System.out.println(ds2163.minimumDifference(new int[] { 1, 2, 3, 4, 5, 6 })); // Output: 0
        System.out.println(ds2163.minimumDifference(new int[] { 7, 8, 9, 10, 11, 12 })); // Output: 0
        System.out.println(ds2163.minimumDifference(new int[] { 1, 1000, 1001, 2000 })); // Output: 998
    }
}
