class Solution {
    public int solution(int n) {
        int count = 0;
        int q = 2;
        int r = 0;
        
        for(int i=1; q>i/2; i++) {
            q = n/i;
            r = n%i;
            if(i%2==1 && r==0) count++;
            if(i%2==0 && i/2==r) count++;
        }
        
        return count;
    }
}