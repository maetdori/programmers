import java.util.*;

class Solution {
    static Map<Character, Integer> seat;
    static boolean[] occupied;
    static char[] friends;
    static String[] needs;
    static int answer;
    
    public int solution(int n, String[] data) {
        seat = new HashMap<>();
        occupied = new boolean[8];
        friends = new char[] {'A','C','F','J','M','N','R','T'};
        needs = data;
        answer = 0;
        
        permutation(0);
        
        return answer;
    }
    
    private void permutation(int index) {
        if(index==8) {
            check();
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(!occupied[i]) {
                occupied[i] = true;
                seat.put(friends[index], i);
                permutation(index+1);
                occupied[i] = false;
            }
        }
    }
    
    private void check() {
        for(int i=0; i<needs.length; i++) {
            int friend1 = seat.get(needs[i].charAt(0));
            int friend2 = seat.get(needs[i].charAt(2));
            char operation = needs[i].charAt(3);
            int interval = needs[i].charAt(4) - '0';
            
            if(operation == '=') {
                if(Math.abs(friend1-friend2) != interval+1)
                    return;
            }
            
            if(operation == '<') {   
                if(Math.abs(friend1-friend2) >= interval+1)
                    return;
            }
            
            if(operation == '>') {
                if(Math.abs(friend1-friend2) <= interval+1)
                    return;
            }
        } 
        answer++;
    }
}