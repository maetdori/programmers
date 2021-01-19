import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()==ch)
                stack.pop();
            else stack.push(ch);
        }
        
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}