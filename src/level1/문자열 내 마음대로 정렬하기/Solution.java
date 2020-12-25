import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        for(int i=0; i<strings.length; i++) 
            answer[i] = strings[i];
        
        Arrays.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n))
                    return 1;
                if(o1.charAt(n) == o2.charAt(n))
                    return o1.compareTo(o2);
                return -1;
            }
        });
        
        return answer;
    }
}