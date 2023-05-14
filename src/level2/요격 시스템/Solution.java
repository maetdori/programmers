import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {

        Arrays.sort(targets, (t1, t2) -> {
            if (t1[1] == t2[1]) {
                return t1[0] - t2[0];
            }
            return t1[1] - t2[1]; 
        });
        
        int cursor = 0;
        int answer = 0;
        
        for (int i = 0; i < targets.length; i++) {
            int left = targets[i][0];
            int right = targets[i][1];
            
            if (left >= cursor) {
                answer ++;
                cursor = right;
            }
        }
        
        return answer;
    }
}