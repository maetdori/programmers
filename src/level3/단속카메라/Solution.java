import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        
        int num = 0;
        int cam = routes[0][1];
        for(int i=1; i<routes.length; i++) {
            if(routes[i][1] < cam)
                cam = routes[i][1];
            if(routes[i][0] > cam) {
                cam = routes[i][1];
                num++;
            }
        }
        
        return num+1;
    }
}