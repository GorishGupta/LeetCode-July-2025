public class DS3307 {
    public char kthCharacter(long k, int[] operations) {
        int i = (int) (Math.ceil(Math.log(k) / Math.log(2))) - 1;
        int count = 0;

        while (k > 1) {
            if (k > (1L << i)) {
                if (operations[i] == 1) {
                    count++;
                }
                k -= (1L << i);
            }
            i--;
        }

        return (char) ('a' + (count % 26));
    }

    public static void main(String[] args) {
        DS3307 ds = new DS3307();
        int[] operations = { 1, 0, 1, 0, 1, 0, 1, };
        System.out.println(ds.kthCharacter(1, operations)); // Output: a
    }
}
