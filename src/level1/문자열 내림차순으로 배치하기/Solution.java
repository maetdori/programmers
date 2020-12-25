import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = s;
        String[] str = s.split("");
        
        Arrays.sort(str);
        
        List<String> list = new ArrayList<>();
        for(String e: str) {
            list.add(e);
        }
        
        Collections.reverse(list);
        
        answer = String.join("", list);
        
        return answer;
    }
}