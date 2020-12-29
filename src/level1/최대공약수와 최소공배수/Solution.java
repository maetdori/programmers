class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int l = n<=m ? n : m; //n과 m 중 작은 수
        
        for(int i=1; i<=l; i++) {
            if(n%i==0 && m%i == 0)
                answer[0] = i;
        }
        
        for(int i=1; i<=l; i++) {
            if(m*i % n == 0) {
                answer[1] = m*i;
                break;
            }
        }
        
        return answer;
    }
}