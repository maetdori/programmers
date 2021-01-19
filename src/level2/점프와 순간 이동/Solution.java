import java.util.*;

public class Solution {
    
    public int solution(int n) {
        
        return move(n);
    }
    
    private int move(int idx) {
        if(idx == 0) 
            return 0;
        else if(idx%2 == 1)
            return move(idx-1) + 1;
        else 
            return move(idx/2);
    }
}