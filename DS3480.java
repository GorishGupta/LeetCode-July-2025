import java.util.ArrayList;
import java.util.List;

public class DS3480 {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }
        for (int[] x : conflictingPairs) {
            right[Math.max(x[0], x[1])].add(Math.min(x[0], x[1]));
        }

        long ans = 0;
        long gain[] = new long[n + 1];
        int maxLeft = 0;
        int secondMax = 0;
        long add = 0;
        for (int r = 1; r <= n; r++) {
            for (int l : right[r]) {
                if (l > maxLeft) {
                    secondMax = maxLeft;
                    maxLeft = l;
                } else {
                    secondMax = Math.max(l, secondMax);
                }
            }
            ans += (long) (r - maxLeft);
            gain[maxLeft] += (long) (maxLeft - secondMax);
            add = Math.max(add, gain[maxLeft]);
        }
        return ans + add;
    }

    public static void main(String[] args) {
        DS3480 ds3480 = new DS3480();
        int n = 5;
        int[][] conflictingPairs = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        long result = ds3480.maxSubarrays(n, conflictingPairs);
        System.out.println("Maximum number of non-conflicting subarrays: " + result);
    }
}
