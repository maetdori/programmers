import java.util.Stack;

class Solution {
    static Stack<String> stack = new Stack<>();
    
    public int[] solution(int n, String[] words) {
        for(int i=0; i<words.length; i++) {
            if(!valid(words[i]))
                return new int[] {i%n+1, i/n+1};
    
            stack.push(words[i]);
        }
        return new int[] {0,0};
    }
    
    private boolean valid(String word) {
        if(!stack.isEmpty()) {
            if(stack.contains(word))
                return false;
            if(stack.peek().charAt(stack.peek().length()-1) != word.charAt(0))
                return false;
        }
        return true;
    }
}