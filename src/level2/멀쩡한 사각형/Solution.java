class Solution {
    public long solution(long w, long h) {
        long gcd = getGCD(w,h);
        long invalid = gcd*(w/gcd + h/gcd -1);
        return w*h-invalid;
    }
    
    public long getGCD(long w, long h) {
        long gcd = 0;
        for(int i=1; i<=w || i<=h; i++) {
            if(w%i==0 && h%i==0)
                gcd = i;
        }
        return gcd;
    }
}