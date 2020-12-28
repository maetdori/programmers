class Solution {
    public String solution(String s) {
        String answer = "";
        char n = 'a'-'A';
        int idx = 0; //단어 내에서의 index
       
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(idx%2==0 && 'a'<=ch && ch<='z') {
                answer += (char)(ch-n);
                idx++;
            }
            else if(idx%2==1 && 'A'<=ch && ch<='Z') {
                answer += (char)(ch+n);
                idx++;
            }
            else if(ch==' ') {
                answer += ch;
                idx = 0;
            }
            else {
                answer += ch;
                idx++;
            }
        }
        
        return answer;
    }
}