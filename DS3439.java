public class DS3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int count = startTime.length;
        int max = 0;
        int[] prefixSum = new int[count + 1];

        for (int i = 0; i < count; i++) {
            prefixSum[i + 1] = prefixSum[i] + endTime[i] - startTime[i];
        }

        for (int i = k - 1; i < count; i++) {
            int occupied = prefixSum[i + 1] - prefixSum[i - k + 1];
            int windowEnd = (i == count - 1) ? eventTime : startTime[i + 1];
            int windowStart = (i == k - 1) ? 0 : endTime[i - k];
            max = Math.max(max, windowEnd - windowStart - occupied);
        }

        return max;
    }

    public static void main(String[] args) {
        DS3439 ds = new DS3439();
        int eventTime = 10;
        int k = 2;
        int[] startTime = { 1, 3, 5, 7 };
        int[] endTime = { 2, 4, 6, 8 };
        System.out.println(ds.maxFreeTime(eventTime, k, startTime, endTime)); // Output: 2
    }
}