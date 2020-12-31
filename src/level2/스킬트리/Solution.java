import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String, Integer> order = new HashMap<String, Integer>(); //key: skill, value: skill priority
        
        String[] sk = skill.split("");
        for(int i=0; i<sk.length; i++) {
            order.put(sk[i], i);
        }
        
        for(int i=0; i<skill_trees.length; i++) {
            int[] learned = new int[skill.length()]; //배웠는지 여부 체크하는 배열
            int flag = 0;
            for(int j=0; j<skill_trees[i].length(); j++) {
                int impossible = 0;
                String cursor = Character.toString(skill_trees[i].charAt(j));
                if(order.containsKey(cursor)) {
                    int prio = order.get(cursor);
                    for(int k=0; k<prio; k++) {
                        if(learned[k]==0) {
                            impossible = 1;
                            break;
                        } 
                    }
                    if(impossible==1) {
                        flag = 1;
                        break;
                    }
                    learned[prio] = 1;
                }
            }
            if(flag==0) answer += 1;
        }
        
        return answer;
    }
}