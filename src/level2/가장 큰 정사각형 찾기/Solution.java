class Solution {
    public int solution(int[][] board) {
        int[][] matrix = new int[board.length+1][board[0].length+1];
        int maxLen = 0;
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(i==0 || j==0) 
                    matrix[i][j] = 0;
                matrix[i+1][j+1] = board[i][j];
            }
        }
        
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j]==1) {
                    matrix[i][j] = 
                        Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1])) + 1;
                    maxLen = Math.max(matrix[i][j], maxLen);
                }
            }
        }
        
        return maxLen*maxLen;
    }
}