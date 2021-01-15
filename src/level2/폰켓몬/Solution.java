import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> type = new HashSet<>();
        int pick = nums.length/2;
        
        for(int poke: nums) {
            type.add(poke);
        }
        
        return Math.min(type.size(), pick);
    }
}