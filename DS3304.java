import java.util.*;

class DS3304 {
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }

    public static void main(String[] args) {
        DS3304 ds = new DS3304();
        System.out.println(ds.kthCharacter(1)); // Output: a
        System.out.println(ds.kthCharacter(2)); // Output: b
        System.out.println(ds.kthCharacter(3)); // Output: c
        System.out.println(ds.kthCharacter(26)); // Output: z
        System.out.println(ds.kthCharacter(27)); // Output: aa
        System.out.println(ds.kthCharacter(28)); // Output: ab
    }
}