class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[] {"4","1","2"};
        int q = n;
        int r = 0;
        
        while(q>0) {
            r = q%3;
            q /= 3;
            if(r==0)
                q -= 1;
            sb.insert(0, arr[r]);
        }
        answer = sb.toString();
        
        return answer;
    }
}