import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] strWithComma = s.split("\\{\\{|\\},\\{|\\}\\}");
        List<int[]> intArrList = new ArrayList<>();
        
        Arrays.sort(strWithComma, (s1, s2)->{return s1.length()-s2.length();});
        
        List<String> tuple = new ArrayList<>();   
        for(int i=1; i<strWithComma.length; i++) {
           for(String num: strWithComma[i].split(",")) {
               if(!tuple.contains(num))
                   tuple.add(num);
           }
        }
        
        int[] answer = new int[tuple.size()];
        for(int i=0; i<tuple.size(); i++) {
            answer[i] = Integer.parseInt(tuple.get(i));
        }
        
        return answer;
    }
}