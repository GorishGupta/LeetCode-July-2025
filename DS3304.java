class DS3304 {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int size = sb.length();
            for (int i = 0; i < size; i++) {
                sb.append((char) ('a' + ((sb.charAt(i) - 'a') + 1) % 26));
            }
        }
        return sb.charAt(k - 1);
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