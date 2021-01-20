import java.util.*;

class Solution {
    static List<Character> listArr[];
    static List<Boolean> checked[];
    static int answer = 0;
    static int row;
    static int col;
    
    public int solution(int m, int n, String[] board) { 
        listArr = new ArrayList[n];
        checked = new ArrayList[n]; //n개 리스트, 리스트당 m개 문자
        row = m; 
        col = n;
        
        for(int i=0; i<n; i++) {
            listArr[i] = new ArrayList<Character>();
            checked[i] = new ArrayList<Boolean>();
            for(int j=m-1; j>=0; j--) {
                listArr[i].add(board[j].charAt(i));
                checked[i].add(false);
            }
        }
        
        delete();
        
        return answer;
    }
    
    private void delete() {
        while(true) {
            check();
            int count = 0;
            
            for(int i=0; i<col; i++) {
                for(int j=0; j<listArr[i].size(); j++) {
                    if(checked[i].get(j)) {
                        listArr[i].remove(j);
                        checked[i].remove(j--);
                        count++;
                    }
                }
            }
            if(count==0) return;
            answer += count;
        }
    }  
    
    private void check() {
        for(int i=0; i+1<col; i++) { 
            for(int j=0; j+1<listArr[i].size() && j+1<listArr[i+1].size(); j++) { 
                if(listArr[i].get(j) == listArr[i].get(j+1) 
                   && listArr[i].get(j) == listArr[i+1].get(j) 
                   && listArr[i].get(j) == listArr[i+1].get(j+1)) {
                    checked[i].set(j, true);
                    checked[i].set(j+1, true);
                    checked[i+1].set(j, true);
                    checked[i+1].set(j+1, true);
                }
            }
        }
    }
}