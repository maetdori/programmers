class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] checked = new int[picture.length][picture[0].length];
        
        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<picture[0].length; j++) {
                int area = getArea(picture, checked, i, j);
                if(area>0) {
                    numberOfArea++;
                    maxSizeOfOneArea = maxSizeOfOneArea>area ? maxSizeOfOneArea : area;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int getArea(int[][] picture, int[][] checked, int i, int j) {
        int area = 1;
        if(picture[i][j]==0 || checked[i][j]++>0) return 0;
        
        if(i>=1 && picture[i-1][j]==picture[i][j]) 
            area += getArea(picture, checked, i-1, j);
        
        if(j>=1 && picture[i][j-1]==picture[i][j]) 
            area += getArea(picture, checked, i, j-1);
        
        if(i+1<picture.length && picture[i][j]==picture[i+1][j]) 
            area += getArea(picture, checked, i+1, j);
        
        if(j+1<picture[0].length && picture[i][j]==picture[i][j+1]) 
            area += getArea(picture, checked, i, j+1);
        
        return area;
    }
    
}