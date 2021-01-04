class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int row = 0; int col = 0;
        int num = 1; //snail에 저장할 수 
        
        for(int i=0; i<n; i++) {
            switch(i%3) {
                case 0: //↓
                    for(int j=0; j<n-i; j++) {
                        snail[row++][col] = num++;
                    }
                    row-=1; col+=1;
                    break;
                case 1: //→
                    for(int j=0; j<n-i; j++) {
                        snail[row][col++] = num++;
                    }
                    col-=1;
                    break;
                case 2: //↖
                    for(int j=0; j<n-i; j++) {
                        snail[--row][--col] = num++;
                    }
                    row+=1;
            }
        }
        int k=0;
        int[] answer = new int[num-1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(snail[i][j]==0) break;
                answer[k++] = snail[i][j];
            }
        }
        return answer;
    }
}