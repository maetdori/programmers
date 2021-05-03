import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            
            @Override 
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0])
                    return arr1[1] - arr2[1];
                return arr1[0] - arr2[0];
            }
        });
        
        return schedule(jobs);
    }
    
    public int schedule(int[][] jobs) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[1] - arr2[1];
            }
        });
        
        queue.offer(jobs[0]);
        int end = jobs[0][0];
        int sum = 0;
        int idx = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            end += cur[1];
            sum += end - cur[0];
            System.out.println(sum);
            
            while(idx < jobs.length && jobs[idx][0] <= end) {
                queue.offer(jobs[idx++]);
            }
            
            if(idx < jobs.length && queue.isEmpty()) {
                end = jobs[idx][0];
                queue.offer(jobs[idx++]);
            }
        }
        
        return sum / jobs.length;
    }
}