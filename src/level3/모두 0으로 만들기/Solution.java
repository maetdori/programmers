import java.util.*;

class Solution {
    static int V;
    static long[] cost;
    static boolean[] visited;
    static List<Integer>[] children;
    static long count = 0;
    
    public long solution(int[] a, int[][] edges) {
        V = a.length;
        cost = new long[V];
        visited = new boolean[V]; 
        children = new ArrayList[V];
        
        long sum = 0;
        for(int i=0; i<V; i++) {
            sum += a[i];
            cost[i] = a[i];
            children[i] = new ArrayList<>();
        }
        
        if(sum != 0) return -1;
        
        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            children[node1].add(node2);
            children[node2].add(node1);
        }
        
        dfs(0);
        return count;
    }
    
    private long dfs(int cur) {
        visited[cur] = true;
        for(int i=0; i<children[cur].size(); i++) { //enhanced for loop 사용하면 런타임 에러 발생
            int next = children[cur].get(i);
            if(visited[next]) continue;
            cost[cur] += dfs(next);
        }
        count += Math.abs(cost[cur]);
        return cost[cur];
    }
}