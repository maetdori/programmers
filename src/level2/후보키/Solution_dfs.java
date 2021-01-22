import java.util.*;

class Solution {
    static List<Set<Integer>> candidateKey;
    static List<Integer> visited;
    static String[][] data;
    static int count = 0;
    
    public int solution(String[][] relation) {
        visited = new ArrayList<>();
        candidateKey = new ArrayList<>();
        data = relation;
        
        for(int i=1; i<=data[0].length; i++) {
            combination(i, 0);
        }
        
        return count;
    }
    
    private void combination(int k, int start) {
        if(k == 0) {
            if(!isUnique().isEmpty() && isMinimal(isUnique()))
                count++;
            return;
        }
        
        for(int i=start; i<data[0].length; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                combination(k-1, i+1);
                visited.remove((Integer)i);
            }
        }
    }
    
    private Set<Integer> isUnique() {
        Set<String> check = new HashSet<>();
        Set<Integer> cand = new HashSet<>();
        
        for(int i=0; i<data.length; i++) {
            String str = "";
            for(int j=0; j<visited.size(); j++) {
                str += data[i][(int)visited.get(j)];
            }
            check.add(str);
        }
        
        if(check.size() == data.length)
            for(int i=0; i<visited.size(); i++) {
                cand.add((int)visited.get(i));
            }
        
        return cand;
    }
    
    private boolean isMinimal(Set<Integer> cand) {
        if(!candidateKey.isEmpty()) {
            for(Set<Integer> set: candidateKey) {
                if(cand.containsAll(set)) 
                    return false;
            }
        }
        candidateKey.add(cand);
        return true;
    }
}