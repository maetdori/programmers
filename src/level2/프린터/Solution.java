import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> prioQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;
        
        for(int p: priorities) {
            prioQ.add(p);
        }
        
        while(!prioQ.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(prioQ.peek()==priorities[i]) {
                    if(i==location) 
                        return answer;
                    prioQ.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}