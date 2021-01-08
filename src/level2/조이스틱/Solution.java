class Solution {
    public int solution(String name) {
        int upDownCnt = 0; //상하 조작
        int lrCnt = 0; //좌우 조작
        
        for(char c: name.toCharArray()) {
            if((c-'A')>13) 
                upDownCnt += 26-(c-'A');
            else upDownCnt += c-'A';
        }
        
        //한 방향으로만 이동할 때 좌우 조작이 최소가 된다.
        int minLR = name.length()-1; 
        
        for(int i=0; i<name.length(); i++) {
            int idx = i;
            
            if(name.charAt(idx)=='A') {
                //A가 어디까지 연속되는지 idx에 저장
                while(idx<name.length() && name.charAt(idx)=='A')
                    idx++;
                
                lrCnt = (i-1)*2 + name.length() - idx;
                minLR = Math.min(minLR,lrCnt);
            }
        }
        return minLR + upDownCnt;
    }
}