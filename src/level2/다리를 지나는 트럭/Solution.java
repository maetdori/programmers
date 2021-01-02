import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int left = weight; //(weight-다리를 건너고 있는 전체 트럭 무게)를 저장
        int cnt = 0; 
        Queue<int[]> bridge = new LinkedList<>(); //다리를 건너고 있는 트럭{무게, 시간} queue, 
        Queue<Integer> waiting = new LinkedList<>(); //대기중인 트럭 queue
        
        for(int truck: truck_weights)
            waiting.offer(truck);
        
        while(!waiting.isEmpty()) { //대기중인 트럭이 없을 때 까지 진행
            int next = waiting.peek();
            if(bridge.size() != bridge_length) { //if(!bridge.isFull())
                if(next <= left) { //next 트럭 무게가 left 이하일 때만 건널 수 있다.
                    waiting.poll();
                    bridge.offer(new int[] {next, 0});
                    left -= next;
                }
            }
            
            for(int[] truck: bridge) { //다리를 건너고 있는 모든 트럭의 시간++
                truck[1]++;
            }
            
            if(bridge.peek()[1] == bridge_length) //제일 앞에 있는 트럭이 다 건너면
                left += bridge.poll()[0];
            
            cnt++;
        }
        return cnt+bridge_length;
    }
}