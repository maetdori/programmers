import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {   
        List<Integer> weight = new ArrayList<>();
        int answer = 0;
        
        Arrays.sort(people);
        
        for(int e: people) {
            weight.add(e);
        }
        
        while(!weight.isEmpty()) {
            if(weight.size()!=1 && weight.get(weight.size()-1)+weight.get(0)<=limit) {
                weight.remove(0);
            }
            weight.remove(weight.size()-1);
            answer++;
        }
        
        return answer;
    }
}