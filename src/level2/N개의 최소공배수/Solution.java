import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int last = arr[arr.length-1];
        
        for(int i=last; ; i++) {
            int flag = 0;
            for(int num: arr) {
                if(i%num != 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag==0) return i;
        }
    }
}