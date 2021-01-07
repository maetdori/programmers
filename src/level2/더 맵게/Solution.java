import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> prioQ = new PriorityQueue<>();
        
        for(int s: scoville)
            prioQ.offer(s);
        
        int cnt = 0;
        while(prioQ.peek() < K) {
            if(prioQ.size()==1) 
                return -1;
            int mix1 = prioQ.poll();
            int mix2 = prioQ.poll();
            prioQ.offer(mix1 + 2*mix2); 
            cnt++;
        }
        
        return cnt;
    }
}