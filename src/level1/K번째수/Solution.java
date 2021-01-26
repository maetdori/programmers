import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int start = 0;
		int end = 0;
		int n = 0;

		for (int i = 0; i < commands.length; i++) {
			start = commands[i][0] - 1;
			end = commands[i][1];
			n = commands[i][2] - 1;
			ArrayList<Integer> list = new ArrayList<>();

			for (int j = start; j < end; j++)
				list.add(array[j]);

			int[] sorted = new int[end - start];

			for (int j = 0; j < list.size(); j++) {
				sorted[j] = list.get(j);
			}

			Arrays.sort(sorted);

			answer[i] = sorted[n];

		}

		return answer;
	}
}