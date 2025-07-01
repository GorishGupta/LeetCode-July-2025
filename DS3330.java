class DS3330 {
    public int possibleStringCount(String word) {
        int n=word.length();
        int count=n;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                count--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        DS3330 ds = new DS3330();
        System.out.println(ds.possibleStringCount("aabbcc")); // Output: 3
        System.out.println(ds.possibleStringCount("abc")); // Output: 3
        System.out.println(ds.possibleStringCount("aaa")); // Output: 1
    }
}