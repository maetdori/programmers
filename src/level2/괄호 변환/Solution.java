import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = Convert(p);
        return answer;
    }
    
    private String Convert(String w) {
        int left = 0;
        int right = 0;
        String u = "";
        String v = "";
        String converted = "";
        
        if(w.equals("")) 
            return w;
        
        String[] str = w.split("");
        
        for(int i=0; i<w.length(); i++) {
            if(str[i].equals("("))
                left++;
            else right++;
            u += str[i];
            if(left==right) break;
        }
        v = w.substring(left+right);
        
        if(isCorrect(u)==true)
            converted = u + Convert(v);
        
        else {
            converted = "(" + Convert(v) + ")";
            u = u.substring(1,u.length()-1);
            for(int i=0; i<u.length(); i++) {
                if(u.charAt(i)=='(')
                    converted += ")";
                else converted += "(";
            }
        }
        
        return converted;
    }
    
    //올바른 문자열인지 확인
    private boolean isCorrect(String s) {
        Stack<Character> stack =new Stack<>();
        int left = 0; 
        int right = 0;
        char a = ' '; 
        char b = ' ';
        
        for(int i=0; i<s.length(); i++) {
            b = stack.push(s.charAt(i));
            if(s.charAt(i)=='(') 
                left++;
            else right++;
            
            if(left<right)
                return false;
            
            if(a=='(' && b==')') {
                stack.pop();
                stack.pop();
                left--; right--;
            }
            if(!stack.empty()) 
                a= stack.peek();
        } 
        
        if(!stack.empty())
            return false;
        return true;
    }
}