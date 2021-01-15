class Solution {
    public int solution(int n) {
        int numOfOne = countBin(n);
        for(int i=n+1; ;i++) {
            if(countBin(i) == numOfOne)
                return i;
        } 
    }
    
    private int countBin(int dec) {
        int q = dec;
        int r = 0;
        int cnt = 0;
        
        while(q>0) {
            r = q%2;
            q = q/2;
            if(r==1) cnt++;
        }
        
        return cnt;
    } 
}