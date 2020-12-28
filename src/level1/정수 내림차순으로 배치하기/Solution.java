import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = Long.toString(n);
        String[] strArr = str.split("");
        Arrays.sort(strArr, Collections.reverseOrder());
        
        str = String.join("", strArr);
        answer = Long.parseLong(str);
        
        return answer;
    }
}