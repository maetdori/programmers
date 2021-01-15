class Solution {
    static int[][] lands;
    static int[][] accumulated;
    
    public int solution(int[][] land) {
        lands = land;
        accumulated = new int[land.length][4];
        
        accumulated[0] = lands[0];
        
        for(int i=1; i<lands.length; i++) {
            calculate(i);
        }
        
        int last = lands.length-1;
        
        return Math.max(accumulated[last][0], 
                         Math.max(accumulated[last][1], 
                                  Math.max(accumulated[last][2], accumulated[last][3])));
    }
    
    private void calculate(int depth) {
        
        for(int i=0; i<4; i++) {
            accumulated[depth][i] =
                Math.max(accumulated[depth-1][(i+1)%4], 
                         Math.max(accumulated[depth-1][(i+2)%4], 
                                  accumulated[depth-1][(i+3)%4])) + lands[depth][i];
        }
    }
}