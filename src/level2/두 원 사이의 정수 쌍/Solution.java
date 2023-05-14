import java.lang.Math;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (long x = 1; x < r2 + 1; x++) {
            answer += (maxY(r2, x) - minY(r1, x)) + 1;
        }

        return answer * 4;
    }

    private double power(long n) {
        return (double) n * n;
    }

    private long minY(long r1, long x) {
        double sqrt = Math.sqrt(Math.max(power(r1) - power(x), 0));

        return sqrt % 1 == 0 ? (long) sqrt : (long) sqrt + 1;
    }

    private long maxY(long r2, long x) {
        return (long) Math.sqrt(Math.max(power(r2) - power(x), 0));
    }
}