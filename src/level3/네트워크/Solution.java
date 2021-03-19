import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<Integer>[] connected = new ArrayList[n];
        
        for(int i=0; i<n; i++)
            connected[i] = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j &&computers[i][j] == 1) {
                    connected[i].add(j);
                    connected[j].add(i);
                }
            }
        }
        
        return bfs(n, connected);
    }
    
    private int bfs(int n, List<Integer>[] connected) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int network = 0;
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            
            queue.offer(i);
            visited[i] = true;
            network++;
            
            while(!queue.isEmpty()) {
                int node = queue.poll();
                
                for(int con: connected[node]) {
                    if(visited[con]) continue;
                    queue.offer(con);
                    visited[con] = true;
                }
            }
        }
        return network;
    }
}