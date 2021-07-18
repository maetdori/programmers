import java.util.*;

class Node {
    int r;
    int c;
    int cnt;
    
    Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int R = maps.length;
        int C = maps[0].length;
        
        return getShortestPath(R, C, maps);
    }
    
    private int getShortestPath(int R, int C, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        int[] rMove = new int[]{-1,1,0,0};
        int[] cMove = new int[]{0,0,-1,1};
        
        queue.offer(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if(cur.r == R-1 && cur.c == C-1)
                return cur.cnt;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + rMove[i];
                int nc = cur.c + cMove[i];
                
                if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                
                if(visited[nr][nc] || maps[nr][nc]==0) continue;
                
                queue.offer(new Node(nr, nc, cur.cnt+1));
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}