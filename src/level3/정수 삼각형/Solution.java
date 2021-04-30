import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        
        for(int i=1; i<len; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for(int j=1; j<i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        Arrays.sort(triangle[len-1]);
        return triangle[len-1][len-1];
    }
}