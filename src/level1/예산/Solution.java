import java.util.Arrays;

class Solution {
	public int solution(int[] d, int budget) {
		int answer = 0;
		int left = budget;
		Arrays.sort(d);

		for (int i = 0; i < d.length; i++) {
			if (d[i] <= left)
				left -= d[i];
			else break;
			answer = i + 1;
		}

		return answer;
	}
}