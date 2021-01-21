import java.util.*;

class Solution {
    static List<String[]> message = new ArrayList<>();
    static Map<String, String> uidName = new HashMap<>();
    
    public String[] solution(String[] record) {
        
        for(String str: record) {
            String[] rec = str.split(" ");
            if(rec[0].equals("Enter"))
                enter(rec[1], rec[2]);
            else if(rec[0].equals("Leave"))
                leave(rec[1]);
            else change(rec[1], rec[2]);
        }
        
        String[] result = new String[message.size()];
        
        for(int i=0; i<message.size(); i++) {
            result[i] = uidName.get(message.get(i)[0]) + message.get(i)[1];
        }
        
        return result;
    }
    
    private void enter(String uid, String name) {
        uidName.put(uid, name);
        message.add(new String[] {uid, "님이 들어왔습니다."});
    }
    
    private void leave(String uid) {
        message.add(new String[] {uid, "님이 나갔습니다."});
    } 
    
    private void change(String uid, String name) {
        uidName.put(uid, name);
    }
}