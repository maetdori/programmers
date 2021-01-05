class Solution {
    public int solution(String s) {
        int min = s.length();
        int flag = 0;
        for(int i=1; i<=s.length()/2; i++) {
            int len = compress(s,i).length();
            if(len<min) {
                min = len;
                flag = i;
            }
            //min = len<min ? len:min;
        }
        System.out.println(flag);
        return min;
    }
    
    private String compress(String str, int k) {
        String str1 = "";
        String str2 = "";
        String result = "";
        int cnt = 1;
        
        for(int i=0; i<=str.length()+k; i+=k) {
            if(i>=str.length()) 
                str2 = "";
            else if(i+k > str.length()) //(예)defdefab에서 ab만 남았을 때
                str2 = str.substring(i); //str2 = "ab";
            else 
                str2 = str.substring(i, i+k); //그 외 일반적인 경우
            
            if(i>0) {
                if(str1.equals(str2)) 
                    cnt++;
                else if(cnt>1) {
                    result += cnt+str1;
                    cnt = 1;
                }
                else result += str1;
            }
            str1 = str2;
        }
        return result;
    }
}