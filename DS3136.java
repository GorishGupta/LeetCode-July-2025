class DS3136 {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }        
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for(char c : word.toCharArray()){
            if(Character.isLetter(c)){
                char ch = Character.toLowerCase(c);
                if(ch =='a' || ch =='o' ||ch =='i' ||ch =='e' ||ch =='u'){
                    hasVowel = true;
                }
                else{
                    hasConsonant = true;
                }
            }
                else if(!Character.isDigit(c)){
                    return false;
                }
            }
        
        return hasVowel && hasConsonant;    
    }

}