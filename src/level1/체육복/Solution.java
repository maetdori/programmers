class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n;
        
        for(int l=0; l<lost.length; l++) {
            for(int r=0; r<reserve.length; r++) {
                if(lost[l]==reserve[r]) {
                    reserve[r] = 0;
                    lost[l] = 0;
                }                
            }
        }
        
        for(int l: lost) {
            int flag = 0;
            if(l == 0) 
                flag = 1;
            
            if(l == 1) {
                for(int r=0; r<reserve.length; r++) {
                    if(l+1 == reserve[r]) {
                        reserve[r] = 0;
                        flag = 1;
                        break;
                    }
                }
            }
            else if(l == n) {
                for(int r=0; r<reserve.length; r++) {
                    if(l-1 == reserve[r]) {
                        reserve[r] = 0;
                        flag = 1;
                        break;
                    }
                }
            }
            else if(1<l && l<n) {
                for(int r=0; r<reserve.length; r++) {
                    if(l-1 == reserve[r]) {
                        reserve[r] = 0;
                        flag = 1;
                        break;
                    }
                    if(l+1 == reserve[r]) {
                        reserve[r] = 0;
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag==0) cnt--;
        }
        
        return cnt;
    }
}