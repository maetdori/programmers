import java.util.*;

class Node {
    int idx;
    int chance;
    int popNum;
    boolean[] popped;
    
    Node(int idx, int chance, int popNum, boolean[] popped) {
        this.idx = idx;
        this.popNum = popNum;
        this.chance = chance;
        this.popped = popped;
    }
}

class Solution {
    static int[] ball;
    static Queue<Node> queue;
    static boolean[] visited;
    static Set<Integer> survived;
    
    public int solution(int[] a) {
        ball = a;
        survived = new HashSet<>();
        
        bfs();
        
        return survived.size();
    }
    
    private void bfs() {
        for(int i=0; i<ball.length; i++) {
            System.out.println();
            queue = new LinkedList<>();
            visited = new boolean[ball.length];
            
            offerQueue(i, 1, 0, visited);
            
            while(!queue.isEmpty()) {
                Node now = queue.poll();
                int chance = now.chance;
                int popNum = now.popNum;
                boolean[] popped = now.popped;
                
                if(popNum == ball.length-1) {
                    for(int j=0; j<popped.length; j++) {
                        if(!popped[j]) {
                            survived.add(ball[j]);
                            break;
                        }
                    }
                    continue;
                }
                
                for(int j=0; j<ball.length; j++) {
                    if(popped[j]) continue;
                    
                    offerQueue(j, chance, popNum, popped);
                }
            }   
        }
    }
    
    private void offerQueue(int idx, int chance, int popNum, boolean[] popped) {
        int lIdx = leftIdx(idx, popped);
        int rIdx = rightIdx(idx, popped);
        
        boolean[] poppedCpy = new boolean[popped.length];
        
        for(int i=0; i<popped.length; i++) 
            poppedCpy[i] = popped[i];
        
        poppedCpy[idx] = true;
            
        if(mustUseChance(idx, lIdx, rIdx)) {
            if(chance == 0) return;
            queue.offer(new Node(idx, 0, popNum+1, poppedCpy));
        }

        else if(canNotUseChance(idx, lIdx, rIdx))
            queue.offer(new Node(idx, chance, popNum+1, poppedCpy));

        else {
            queue.offer(new Node(idx, 0, popNum+1, poppedCpy));
            if(chance == 1)
                queue.offer(new Node(idx, 1, popNum+1, poppedCpy));
        } 
            
    }
    
    //찬스를 반드시 사용해야 하는 경우 true를 리턴
    private boolean mustUseChance(int idx, int lIdx, int rIdx) {
        if(lIdx == -1 && ball[idx] < ball[rIdx])
            return true;
        if(rIdx == ball.length && ball[idx] < ball[lIdx])
            return true;
        if(lIdx != -1 && rIdx != ball.length &&
          ball[idx] < ball[lIdx] && ball[idx] < ball[rIdx])
            return true;
        return false;
    }
    
    //찬스를 사용할 수 없는 경우 true를 리턴
    private boolean canNotUseChance(int idx, int lIdx, int rIdx) {
        if(lIdx == -1 && ball[idx] > ball[rIdx])
            return true;
        if(rIdx == ball.length && ball[idx] > ball[lIdx])
            return true;
        if(lIdx != -1 && rIdx != ball.length &&
          ball[idx] > ball[lIdx] && ball[idx] > ball[rIdx])
            return true;
        return false;
    }
    
    //idx 왼쪽의 터지지 않은 풍선 중 가장 가까운 것의 index를 리턴
    private int leftIdx(int idx, boolean[] popped) {
        int left = idx-1;
        
        while(left >= 0) {
            if(!popped[left])
                break;
            left--;
        }
        return left;
    }
    
    //idx 오른쪽의 터지지 않은 풍선 중 가장 가까운 것의 index를 리턴
    private int rightIdx(int idx, boolean[] popped) {
        int right = idx+1;

        while(right < popped.length) {
            if(!popped[right])
                break;
            right++;
        }
        return right;
    }
}