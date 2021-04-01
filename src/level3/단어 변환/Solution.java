import java.util.*;

class Node {
    String word;
    int cnt;
    
    Node(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.word.equals(target))
                return node.cnt;
            
            for(int i=0; i<words.length; i++) {
                if(visited[i]) continue;
                if(changeable(node.word, words[i])) {
                    queue.offer(new Node(words[i], node.cnt+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    private boolean changeable(String from, String to) {
        int diff = 0;
        
        for(int i=0; i<to.length(); i++) {
            if(from.charAt(i) != to.charAt(i))
                diff++;
        }
        
        if(diff == 1) return true;
        return false;
    }
}