class Solution {
    public String solution(String s) {
        String answer = "";
        int mod = s.length()/2;
        int rem = s.length()%2;
        
        if(rem == 0) 
            answer = Character.toString(s.charAt(mod-1)) + Character.toString(s.charAt(mod));
        else 
            answer = Character.toString(s.charAt(mod));
        
        return answer;
    }
}