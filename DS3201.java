public class DS3201 {
    public int maximumLength(int[] nums) {
        int c = nums[0] % 2, odd = 0, even = 0, both = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            if (num % 2 == c) {
                both++;
                c = 1 - c; // Toggle the parity
            }
        }
        return Math.max(both, Math.max(even, odd));
    }

    public static void main(String[] args) {
        DS3201 ds3201 = new DS3201();
        System.out.println(ds3201.maximumLength(new int[] { 1, 2, 3, 4, 5 })); // Output: 5
        System.out.println(ds3201.maximumLength(new int[] { 2, 4, 6 })); // Output: 3
        System.out.println(ds3201.maximumLength(new int[] { 1, 3, 5 })); // Output: 3

    }
}