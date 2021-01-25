import java.util.*;

class File implements Comparable<File> { 
    public String head;
    public String number;
    public String tail;
    
    public File(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    @Override
    public int compareTo(File file) {
        if(this.head.toLowerCase().equals(file.head.toLowerCase())) 
            return Integer.parseInt(this.number) - Integer.parseInt(file.number);
        else return this.head.toLowerCase().compareTo(file.head.toLowerCase());
    }
}


class Solution {
    public String[] solution(String[] files) {
        File[] fileArr = new File[files.length];
        String[] answer = new String[files.length];
        
        for(int i=0; i<files.length; i++) {
            fileArr[i] = partition(files[i]);
        }
        
        Arrays.sort(fileArr);
        
        for(int i=0; i<fileArr.length; i++) {
            answer[i] = fileArr[i].head + fileArr[i].number + fileArr[i].tail;
        }
        
        return answer;
    }
    
    private File partition(String str) { 
        String head = ""; 
        String number = "";
        String tail = "";
        int i = 0;
        int flag;
        
        while(str.charAt(i)<'0' || str.charAt(i)>'9') 
            i++;
        head = str.substring(0, i);
        flag = i;

        while(i<str.length() && '0'<=str.charAt(i) && str.charAt(i)<='9') 
            i++;
        number = str.substring(flag, i);
        
        if(i<str.length()) 
            tail = str.substring(i);
        
        return new File(head, number, tail);
    }
}