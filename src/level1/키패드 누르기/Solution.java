class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int leftX = 0; //왼손 위치. *의 위치를 (0,0)라 하자.
        int leftY = 0;
      
        int rightX = 2; //오른손 위치.
        int rightY = 0;
        
        int[] xPos = new int[] {1,0,1,2,0,1,2,0,1,2}; //0~9 키패드의 x좌표
        int[] yPos = new int[] {0,3,3,3,2,2,2,1,1,1}; //0~9 키패드의 y좌표
        
        for(int i=0; i<numbers.length; i++) {
            int next = numbers[i];
            
            switch(xPos[next]) { 
            
                case 0:
                    answer += "L";
                    leftX = xPos[next];
                    leftY = yPos[next];
                    break;
                case 2:
                    answer += "R";
                    rightX = xPos[next];
                    rightY = yPos[next];
                    break;
                default:
                    int lDiffer = 
                        Math.abs(xPos[next]-leftX) + Math.abs(yPos[next]-leftY);
                    int rDiffer = 
                        Math.abs(xPos[next]-rightX) + Math.abs(yPos[next]-rightY);
                    if(lDiffer == rDiffer) {
                        if(hand.equals("left")) {
                            answer += "L";
                            leftX = xPos[next];
                            leftY = yPos[next];
                        }
                        else {
                            answer += "R";
                            rightX = xPos[next];
                            rightY = yPos[next];
                        }
                    }
                    else if (lDiffer<rDiffer) {
                        answer += "L";
                        leftX = xPos[next];
                        leftY = yPos[next];
                    }
                    else {
                        answer += "R";
                        rightX = xPos[next];
                        rightY = yPos[next];
                    }
                    break;
            }
        }
        return answer;
    }
}