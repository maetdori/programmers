class Solution {
    public String solution(String s) {
        char[] words = s.toLowerCase().toCharArray();
        
        for(int i=0; i<words.length; i++) {
            if('a'<=words[i] && words[i]<='z') {
                if(i==0 || words[i-1]==' ') 
                    words[i] += 'A'-'a';
            }
        }
        
        return new String(words);
    }
}