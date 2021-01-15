import java.util.StringTokenizer;

class Solution {
    static StringTokenizer st;
    static StringBuilder sb;
    static int call = 0;
    static int zero = 0;
    static String str;
    
    public int[] solution(String s) {
        str = s;
        
        while(!str.equals("1")) {
            removeZero();
            decToBin();
        }
        
        return new int[] {call, zero};
    }
    
    private void removeZero() {
        st = new StringTokenizer(str, "0");
        sb = new StringBuilder();
        
        while(st.hasMoreTokens()) {
            sb.append(st.nextToken());
        }
        
        zero += str.length()-sb.length();
        str = sb.toString();
    }
    
    private void decToBin() {
        sb = new StringBuilder();
        int q = str.length();
        int r = 0;  
        
        while(q>0) {
            r = q%2;
            q = q/2;
            sb.append(Integer.toString(r));
        }

        str = sb.reverse().toString();
        call++;
    }
}