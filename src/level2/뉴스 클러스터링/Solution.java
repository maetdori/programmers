import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        list1 = makeSet(str1.toLowerCase());
        list2 = makeSet(str2.toLowerCase());
        
        int unionSize = list1.size();
        int interSize = 0;
        
        for(String s: list2) {
            if(list1.contains(s)) {
                list1.remove(s);
                interSize++;
            }
            else unionSize++;
        }
        
        if(unionSize == 0) 
            return 65536;
        else 
            return interSize*65536/unionSize;
    }
    
    private List<String> makeSet(String str) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length()-1; i++) {
            if(checkAlphabet(str.substring(i,i+2))) {
                list.add(str.substring(i,i+2));
            }
        }
        return list;
    }
    
    private boolean checkAlphabet(String str) {
        if('a'<=str.charAt(0) && str.charAt(0)<='z' 
           && 'a'<=str.charAt(1) && str.charAt(1)<='z')
            return true;
        return false;
    }
}