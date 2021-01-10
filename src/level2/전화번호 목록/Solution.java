import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    static int[] num; //numbers를 int형 배열에 저장
    static boolean[] visited; //방문한 노드인지 확인
    static Set<Integer> set = new HashSet<>(); //중복없이 저장하기 위하여 Set을 사용
    
    public int solution(String numbers) {
        num = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++)
            num[i] = Character.getNumericValue(numbers.charAt(i));
        
        for(int i=1; i<=num.length; i++) //i자리수의 가능한 모든 조합을 구한다.
            permutation(1,i,0);
        
        getPrimeNumbers();
        
        return set.size();
    }
    
    /**
    * 가능한 조합을 모두 찾아 set에 저장(DFS)
    *
    * @param len: 숫자 자리수
    * @param value: set에 추가할 숫자
    */
    private void permutation(int depth, int len, int value) {
        if(depth==len+1) {
            set.add(value);
            return;
        }
        
        for(int i=0; i<num.length; i++) {
            if(depth==1 && num[i]==0) continue; //맨 앞자리 수가 0인 경우를 허용하지 않음
            if(len==1 && num[i]==1) continue; //1은 소수가 아님
            if(!visited[i]) {
                visited[i] = true;
                int tmp = num[i];
                for(int j=0; j<len-depth; j++)
                    tmp *= 10;
                value += tmp;
                permutation(depth+1, len, value);
                visited[i] = false;
                value -= tmp; //이렇게 고쳐준다
                //value = 0; //이새끼..
            }
        }
    }
    /**
    * set에서 소수가 아닌 수를 제거한다.
    */
    private void getPrimeNumbers() {
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()) {
            int e = itr.next();
            for(int i=2; i<=Math.sqrt(e); i++) {
                if(e%i == 0) {
                    itr.remove();
                    break;
                }
            }
        }
    }
}