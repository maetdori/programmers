class Solution {
    static int[] number;
    static boolean[] visited;
    static int count = 0;
    static int sum = 0;
    
    public int solution(int[] nums) {
        number = nums;
        visited = new boolean[nums.length];
        
        combination(3, 0);
        
        return count;
    }
    
    private void combination(int k, int start) { //k==뽑을개수
        if(k==0) {
            if(isPrime(sum))
                count++;
            return;
        }
        
        for(int i=start; i<number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sum += number[i];
                combination(k-1, i+1);
                visited[i] = false;
                sum -= number[i];
            }
        }
    }
    
    private boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}