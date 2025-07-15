class DS3136 {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (ch == 'a' || ch == 'o' || ch == 'i' || ch == 'e' || ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {
        DS3136 ds3136 = new DS3136();
        System.out.println(ds3136.isValid("hello123")); // Output: true
    }
}