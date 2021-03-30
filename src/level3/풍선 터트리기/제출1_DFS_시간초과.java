class Solution {
    static int[] balloon;
    static boolean[] survived;
    
    public int solution(int[] a) {
        boolean[] popped = new boolean[a.length];
        survived = new boolean[a.length];
        balloon = a;
        
        dfs(1, 1, popped);
        
        int cnt = 0;
        for(boolean surv: survived)
            if(surv) cnt++;
        
        return cnt;
    }
    
    private void dfs(int depth, int chance, boolean[] popped) {
        if(depth == popped.length) {
            for(int i=0; i<popped.length; i++) {
                if(!popped[i]) {
                    survived[i] = true;
                    return;
                }
            }
        }
        for(int i=0; i<popped.length; i++) {
            if(popped[i]) continue;
            
            int lIdx = leftIdx(i, popped);
            int rIdx = rightIdx(i, popped);
            
            //찬스를 이미 사용한 경우
            if(chance == 0) {
                if(mustUseChance(i, lIdx, rIdx))
                    continue;
                popped[i] = true;
                dfs(depth+1, 0, popped);
            }
	
            //찬스를 사용할 수 있는 경우
            else {
                popped[i] = true;
                if(mustUseChance(i, lIdx, rIdx))
                    dfs(depth+1, 0, popped);

                else if(canNotUseChance(i, lIdx, rIdx))
                    dfs(depth+1, 1, popped);

                else {
                    dfs(depth+1, 0, popped);
                    dfs(depth+1, 1, popped);
                }
            }
            popped[i] = false;
        }
    }
    
    //찬스를 반드시 사용해야 하는 경우 true를 리턴
    private boolean mustUseChance(int idx, int lIdx, int rIdx) {
        if(lIdx == -1 && balloon[idx] < balloon[rIdx])
            return true;
        if(rIdx == balloon.length && balloon[idx] < balloon[lIdx])
            return true;
        if(lIdx != -1 && rIdx != balloon.length &&
          balloon[idx] < balloon[lIdx] && balloon[idx] < balloon[rIdx])
            return true;
        return false;
    }
    
    //찬스를 사용할 수 없는 경우 true를 리턴
    private boolean canNotUseChance(int idx, int lIdx, int rIdx) {
        if(lIdx == -1 && balloon[idx] > balloon[rIdx])
            return true;
        if(rIdx == balloon.length && balloon[idx] > balloon[lIdx])
            return true;
        if(lIdx != -1 && rIdx != balloon.length &&
          balloon[idx] > balloon[lIdx] && balloon[idx] > balloon[rIdx])
            return true;
        return false;
    }
    
    //idx 왼쪽의 터지지 않은 풍선 중 가장 가까운 것의 index를 리턴
    private int leftIdx(int idx, boolean[] popped) {
        int left = idx-1;
        
        while(left >= 0) {
            if(!popped[left])
                break;
            left--;
        }
        return left;
    }
    
    //idx 오른쪽의 터지지 않은 풍선 중 가장 가까운 것의 index를 리턴
    private int rightIdx(int idx, boolean[] popped) {
        int right = idx+1;

        while(right < popped.length) {
            if(!popped[right])
                break;
            right++;
        }
        return right;
    }
}