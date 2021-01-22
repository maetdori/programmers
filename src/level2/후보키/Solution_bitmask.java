import java.util.*;

class Solution {
    static List<Integer> candidateKey;
    static int rowLen;
    static int colLen;
    
    public int solution(String[][] relation) {
        candidateKey = new ArrayList<>();
        rowLen = relation.length;
        colLen = relation[0].length;
        int count = 0;
        
        for(int set=1; set < (1 << colLen); set++) {
            if(isMinimal(set) && isUnique(set, relation)) {
                candidateKey.add(set);
                count++;
            }
        }
        
        return count;
    }
    
    
    private boolean isUnique(int set, String[][] relation) {
        Set<String> temp = new HashSet<>();
        
        for(int r=0; r<rowLen; r++) {
            StringBuilder sb = new StringBuilder();
            
            for(int c=0; c<colLen; c++) {
                if((set & (1<<c)) != 0) 
                    sb.append(relation[r][c]);
            }
            temp.add(sb.toString());
        }
        
        if(temp.size() == relation.length)
            return true;
        
        return false;
    }
    
    private boolean isMinimal(int set) {
        for(int key: candidateKey) {
            if((key & set) == key) 
                return false;
        }
        return true;
    }
}