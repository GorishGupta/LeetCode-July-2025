import java.util.*;

class DS2402 {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Min-heap for free rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        // Min-heap for ongoing meetings: [endTime, roomNumber]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int[] count = new int[n]; // Meetings held by each room

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            int duration = end - start;

            // Free up rooms that have ended by this meeting's start time
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                // Use the smallest free room
                int room = freeRooms.poll();
                count[room]++;
                busyRooms.offer(new long[] { start + duration, room });
            } else {
                // No room is free → wait for the earliest room to free up
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                count[room]++;
                busyRooms.offer(new long[] { newEnd, room });
            }
        }

        // Find the room with the maximum number of meetings
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }

        return maxRoom;
    }

    public static void main(String[] args) {
        DS2402 ds = new DS2402();
        int n = 3;
        int[][] meetings = { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 9 }, { 4, 6 } };
        System.out.println(ds.mostBooked(n, meetings)); // Output: 0
    }
}