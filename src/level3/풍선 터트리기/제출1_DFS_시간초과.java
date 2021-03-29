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

            if(chance == 0) {
                if(mustUseChance(i, lIdx, rIdx))
                    continue;
                popped[i] = true;
                dfs(depth+1, 0, popped);
            }
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
    
    private int leftIdx(int idx, boolean[] popped) {
        int left = idx-1;
        
        while(left >= 0) {
            if(!popped[left])
                break;
            left--;
        }
        return left;
    }
    
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