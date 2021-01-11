import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book, new Comparator<String>() {
           
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                String prefix = phone_book[j].substring(0, phone_book[i].length());
                if(prefix.equals(phone_book[i])) 
                    return false;
            }
        }
        
        return true;
    }
}