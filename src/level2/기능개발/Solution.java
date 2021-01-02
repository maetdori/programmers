import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> speed = new ArrayList<>(); //speeds를 저장할 list
        List<Integer> status = new ArrayList<>(); //진행 상태 update
        List<Integer> deploy = new ArrayList<>(); //배포 기능 수
        int finished = 0; //개발 완료된 기능 수
        
        for(int i=0; i<speeds.length; i++) {
            status.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        while(!status.isEmpty()) {
            
            if(status.get(0) >= 100) { //0번 째 기능이 100% 이상일 때
                status.remove(0);
                speed.remove(0);
                finished++;
                continue; 
            }
            
            if(finished > 0) { //배포할 수 있는 기능이 1개 이상일 때 
                deploy.add(finished);
                finished = 0;
            }
            
            for(int i=0; i<status.size(); i++) { 
                status.set(i, status.get(i)+speed.get(i)); //진행 상태 update
            }
        }
        deploy.add(finished); //배포할 수 있는 기능 수 저장
        
        int[] answer = new int[deploy.size()];
        for(int i=0; i<deploy.size(); i++) {
            answer[i] = deploy.get(i);
        }    
        return answer;
    }
}