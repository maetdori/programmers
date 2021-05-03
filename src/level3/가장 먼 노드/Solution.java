import java.util.*;

class Solution {
    static List<Integer>[] list;
    
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n+1];
        
        for(int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
            int n1 = edge[i][0];
            int n2 = edge[i][1];
            
            list[n1].add(n2);
            list[n2].add(n1);
        }
        
        return bfs(n+1);
    }
    
    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        
        queue.offer(1);
        visited[1] = 1;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next: list[cur]) {
                if(visited[next] > 0) continue;
                visited[next] = visited[cur] + 1;
                queue.offer(next);
            }
        }
        return count(n, visited);
    }
    
    private int count(int n, int[] visited) {
        Arrays.sort(visited);
        int max = visited[n-1];
        int cnt = 1;
        for(int i=n-2; i>=0 ; i--) {
            if(visited[i] != max) break;
            cnt++;
        }
        return cnt;
    }
}