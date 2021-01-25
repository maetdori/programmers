class Solution {
    static String[] atof = new String[] {"A","B","C","D","E","F"};
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder("0");
        int last = m*t-(m-p);
        
        for(int num=0; sb.length() <= last; num++)
            sb.append(decToN(num, n));
        
        String total = sb.toString();
        
        StringBuilder result = new StringBuilder();
        for(int i=p-1; i<=last; i+=m) {
            result.append(Character.toString(total.charAt(i)));
        }
        
        return result.toString();
    }
    
    private String decToN(int dec, int n) {
        StringBuilder sb = new StringBuilder();
        int q = dec;
        int r = 0;
        
        while(q>0) {
            r = q%n;
            q = q/n;
            if(r >= 10)
                sb.append(atof[r-10]);
            else sb.append(Integer.toString(r));
        }
        
        return sb.reverse().toString();
    }
}