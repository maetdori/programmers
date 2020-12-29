class Solution {
    static int[] bucket = new int[1000];
    static int cnt;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        cnt = 0;
        
        for(int e: moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][e-1] != 0) {
                    push(board[i][e-1]);
                    board[i][e-1] = 0;
                    break;
                }
            }
            
            if(cnt<2) 
                continue;
            else if(bucket[cnt-2] == bucket[cnt-1]) {
                pop();
                answer += 2;
            }
            
            for(int i=0; i<15; i++) {
                System.out.print(bucket[i] + " ");
            }
            System.out.println();
        }
        
        return answer;
    }
    
    public void push(int e) {
        bucket[cnt] = e;
        cnt++;
    }
    
    public void pop() {
        bucket[--cnt] = 0;
        bucket[--cnt] = 0;
    }
}