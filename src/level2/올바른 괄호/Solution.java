import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()=='(' && ch==')')
                stack.pop();
            else stack.push(ch);
        }
        
        if(stack.isEmpty()) 
            return true;
        else return false;
    }
}