import java.util.*;

class Solution {
    public long solution(int[] A, int[] B) {
        int min = 0;
        Integer[] integerB = new Integer[B.length];
        
        for(int i=0; i<B.length; i++)
            integerB[i] = (Integer)B[i];
        
        Arrays.sort(A);
        Arrays.sort(integerB, Collections.reverseOrder());
        
        for(int i=0; i<A.length; i++) {
            min += A[i]*(int)integerB[i];
        }
        
        return min;
    }
}