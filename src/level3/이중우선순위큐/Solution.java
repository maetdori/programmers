import java.util.*;

class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public int[] solution(String[] operations) {
        for(String cmd: operations) {
            operate(cmd);
        }
        
        List<Integer> intersection = new ArrayList<>();
        for(int num: maxHeap) {
            if(minHeap.contains(num)) intersection.add(num);
        }
        if(intersection.isEmpty()) return new int[]{0,0};
        Collections.sort(intersection, Collections.reverseOrder());
        return new int[]{intersection.get(0), intersection.get(intersection.size()-1)};
    }
    
    private void operate(String cmd) {
        if(cmd.charAt(0) == 'I') {
            int num = Integer.parseInt(cmd.substring(2));
            minHeap.offer(num);
            maxHeap.offer(num);
        }
        else if(cmd.charAt(2) == '1') {
            while(!maxHeap.isEmpty() && !minHeap.contains(maxHeap.poll())) {

            }
        }
        else {
            while(!minHeap.isEmpty() && !maxHeap.contains(minHeap.poll())) {
                
            }
        }
    }
}