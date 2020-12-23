import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hash = new HashMap<>();
        
        for(String p : participant) {
            int value;
            if(hash.get(p) == null) {
                value = 1;
            }
            else value = hash.get(p) + 1;
            
            hash.put(p, value);
        }
        
        for(String c : completion) {
            int value = hash.get(c) - 1;
            hash.put(c, value);
        }
        
        for(String key : hash.keySet()) {
            if(hash.get(key) == 1) 
                answer = key;
        }
        return answer;
    }
}