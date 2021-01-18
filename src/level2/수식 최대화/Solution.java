import java.util.*;

class Solution {
    List<Long> operand = new ArrayList<>();
    List<Character> operator = new ArrayList<>();
    List<Character> operType = new ArrayList<>();  
    boolean[] visited;
    long max = 0;
    
    public long solution(String expression) {
        String[] op = expression.split("\\+|\\-|\\*");
        
        for(String s: op) 
            operand.add(Long.parseLong(s));

        for(char ch: expression.toCharArray()) {
            if(ch=='+' || ch=='-' || ch=='*')
                operator.add((Character)ch);
        }
        
        for(Character ch: operator) {
            if(!operType.contains(ch))
                operType.add(ch);
        }
        
        visited = new boolean[operType.size()];
        
        dfs(0, new char[operType.size()]);
        
        return max;
    }
    
    private void dfs(int depth, char[] prio) {
        if(depth == operType.size()) {
            List<Long> numTmp = new ArrayList<>(operand);
            List<Character> operTmp = new ArrayList<>(operator);
            
            for(int i=0; i<prio.length; i++) {
                for(int j=0; j<operTmp.size(); j++) {
                    if(operTmp.get(j) == prio[i]) {
                        numTmp.set(j, calculate(numTmp.get(j), numTmp.remove(j+1), prio[i]));
                        operTmp.remove(j);
                        j--;
                    }
                }
            }
            max = Math.max(max, Math.abs(numTmp.get(0)));  
            return;
        }
        
        for(int i=0; i<operType.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                prio[depth] = operType.get(i);
                dfs(depth+1, prio);
                visited[i] = false;
            }
        }
    }
    
    private long calculate(long num1, long num2, char op) {
        if(op=='+')
            return num1 + num2;
        else if(op=='-')
            return num1 - num2;
        else
            return num1 * num2;
    }
}