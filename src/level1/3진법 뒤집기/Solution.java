import java.util.ArrayList;

class Solution {
	public int solution(int n) {
		int answer = 0;
		int tmp = n;
		int q = 1;
		int r = 0;
		ArrayList<Integer> inversed = new ArrayList<>();

		while (q > 0) {
			q = tmp / 3;
			r = tmp % 3;
			tmp = q;
			inversed.add(r);
		}

		for (int i = 0; i < inversed.size(); i++) {
			int th = 1;
			for (int j = 1; j < inversed.size() - i; j++) {
				th *= 3;
			}
			answer += inversed.get(i) * th;
		}

		return answer;
	}
}