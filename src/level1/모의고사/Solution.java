import java.util.ArrayList;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] A1 = {1, 2, 3, 4, 5};
		int[] A2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] A3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = new int[4];
		int max = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == A1[i % A1.length])
				score[1]++;
			if (answers[i] == A2[i % A2.length])
				score[2]++;
			if (answers[i] == A3[i % A3.length])
				score[3]++;
		}

		max = Math.max(score[1], Math.max(score[2], score[3]));

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i < 4; i++) {
			if (score[i] == max)
				list.add(i);
		}

		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}