class Solution {
    public String solution(String number, int k) {
        int delNum = k;
        String suffix = number;
        String answer = "";
        
        while(delNum>0) {
            char max = '0';
            int maxPos = 0;
            
            if(suffix.length()==delNum)
                return answer;
            
            for(int i=0; i<delNum+1; i++) {
                if(max < suffix.charAt(i)) {
                    max = suffix.charAt(i);
                    maxPos = i;
                    if(max=='9') break; 
                }
            }
            answer += Character.toString(suffix.charAt(maxPos));
            suffix = suffix.substring(maxPos+1);
            delNum -= maxPos;
        }
        
        answer += suffix;
        
        return answer;
    }
}