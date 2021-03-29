import java.util.*;

class Solution {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        
        int minL = a[0];
        int minR = a[a.length-1];
        
        for(int i=1; i<a.length; i++) {
            set.add(minL);
            minL = Math.min(minL, a[i]);
        }
        
        for(int i=a.length-1; i>=0; i--) {
            set.add(minR);
            minR = Math.min(minR, a[i]);
        }
        
        return set.size();
    }
}