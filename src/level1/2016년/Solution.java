class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] dates = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        
        for(int i=0; i<a-1; i++) 
            sum += dates[i];
        
        sum += b;
        
        answer = day[sum%7];
        
        return answer;
    }
}