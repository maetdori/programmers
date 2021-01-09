import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Integer[] cite = new Integer[citations.length];
        
        for(int i=0; i<citations.length; i++) {
            cite[i] = citations[i];
        }
        
        Arrays.sort(cite, Collections.reverseOrder());
        
        if(cite[0] == 0) 
            return 0;
        
        if(cite[cite.length-1] >= cite.length) 
            return cite.length;
        
        for(int i=0; i<cite.length; i++) {
            if(cite[i] < i+1) 
                return i;
        }
        
        return 0;
    }
}