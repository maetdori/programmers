import java.util.*;

class Node {
    int win;
    int defeat;
}

class Solution {
    static List<Integer>[] adj;
    static Node[] nodes;
    static int N;
    
    public int solution(int n, int[][] results) {
        adj = new ArrayList[n+1];
        nodes = new Node[n+1];
        N = n;
        
        for(int i=0; i<N+1; i++) {
            adj[i] = new ArrayList<>();
            nodes[i] = new Node();
        }
        
        for(int i=0; i<results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            
            adj[winner].add(loser);
        }
        
        nodeUpdate();
        return hasRank();
    }
    
    private void nodeUpdate() {    
        for(int i=1; i<N+1; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N+1];
            
            visited[i] = true;
            queue.offer(i);
            
            while(!queue.isEmpty()) {
                int winner = queue.poll();
                
                for(int loser: adj[winner]) {
                    if(visited[loser]) continue;
                    visited[loser] = true;
                    queue.offer(loser);
                    nodes[i].win++;
                    nodes[loser].defeat++;
                }
            }
        }
    }
    
    private int hasRank() {
        int count = 0;
        for(Node node: nodes) {
            if(node.win + node.defeat == N-1) count++;
        }
        return count;
    }
}