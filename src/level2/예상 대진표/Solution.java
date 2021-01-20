class Solution {
    static int round = 1;
    public int solution(int n, int a, int b) {
        check(a-1, b-1);
        return round;
    }
    
    private void check(int idx1, int idx2) {
        if(idx1/2 == idx2/2) 
            return;
        round++;
        check(idx1/2, idx2/2);
    }
}