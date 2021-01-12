class Solution {
    static int answer = 0;
    static boolean[][] visited;
    
    public int solution(int[] numbers, int target) {
        int[][] plusMinus = new int[numbers.length][2];
        
        for(int i=0; i<numbers.length; i++) {
            plusMinus[i][0] = numbers[i];
            plusMinus[i][1] = -numbers[i];
        }
        
        visited = new boolean[numbers.length][2];
        
        targetNumber(0, plusMinus, 0, target);
        
        return answer;
    }
    
    public void targetNumber(int depth, int[][] numbers, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target)
                answer++;
            return;
        }
        
        for(int i=0; i<=1; i++) {
            if(visited[depth][i]==false) {
                visited[depth][i] = true;
                sum += numbers[depth][i];
                
                targetNumber(depth+1, numbers, sum, target);
                
                visited[depth][i] = false;
                sum -= numbers[depth][i];
            }
        }
    }
}