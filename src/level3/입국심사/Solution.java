import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = Long.MAX_VALUE;
        long start = times[0];
        long end = (long)times[times.length-1] * n;
        
        while(start <= end) {
            long done = 0;
            long mid = (start + end) / 2;
            
            for(int time: times) {
                done += mid / time;
            }
            
            if(done >= n) {
                answer = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        
        return answer;
    }
}