import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> hash = new HashMap<>();
        int answer = 1;
        
        for(String[] s: clothes) {
            if(hash.containsKey(s[1]))
                hash.put(s[1], hash.get(s[1])+1);
            else hash.put(s[1], 1);
        }
        
        for(String key: hash.keySet()) {
            answer *= (hash.get(key)+1);
        }
        
        
        return answer-1;
    }
}