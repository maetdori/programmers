class Solution {
    public int solution(int n) {
        int f1 = 1;
        int f2 = 1;
        int answer = 1;
        int mod = 1000000007;
        
        for(int i=2; i<=n; i++) {
            answer = (f1+f2) % mod;
            f1 = f2;
            f2 = answer;
        }
        
        return answer;
    }
}