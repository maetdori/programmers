import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Integer[] cite = new Integer[citations.length];
        
        for(int i=0; i<citations.length; i++) {
            cite[i] = citations[i];
        }
        
        Arrays.sort(cite, Collections.reverseOrder());
        
        for(int i=0; i<cite.length; i++) {
            if(cite[i] < i+1) 
                return i;
        }
        
        return cite.length;
    }
}