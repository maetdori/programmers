import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if(str[0].equals("0")) return str[0]; //str의 원소가 모두 0이면 "0"을 리턴
        
        for(int i=0; i<str.length; i++) {
            answer += str[i];
        }
        
        return answer;
    }
}