class Solution {
    static int[][] matrix;
    static int zero;
    static int one;
    
    public int[] solution(int[][] arr) {
        matrix = arr;
        find(arr.length, 0, 0);
        return  new int[] {zero, one};
    }
    
    public void find(int size, int row, int col) {
        int num = 0;
        boolean flag = true;
        
        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(i==row && j==col)
                    num = matrix[i][j];
                
                if(matrix[i][j] != num) {
                    
                    find(size/2, row, col);
                    find(size/2, row, col+size/2);
                    find(size/2, row+size/2, col);
                    find(size/2, row+size/2, col+size/2);
                    
                    return;
                }
            }
        }
        
        if(matrix[row][col] == 0) 
            zero++;
        else one++;
        
        return;
    }
}