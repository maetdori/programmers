import java.util.*;

class Solution {
    static Queue<String> input = new LinkedList<>();
    static List<String> list = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int idx = 0;
    
    public int[] solution(String msg) {
        
        for(String str: msg.split("")) {
            input.offer(str);
        }
        
        for(char ch='A'; ch<='Z'; ch++) {
            list.add(Character.toString(ch));
        }
        
        isThere();
        answer.add(idx+1);
        
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
           result[i] = answer.get(i);
        }
        
        return result;
    }
    
    private void isThere() {
        while(!input.isEmpty()) {
            sb.append(input.peek());
            if(list.contains(sb.toString())) {
                input.poll();
                idx = list.indexOf(sb.toString());
                isThere();
            }
            else {
                list.add(sb.toString());
                sb.setLength(0);
                answer.add(idx+1);
                return;
            }
        }
    }
}