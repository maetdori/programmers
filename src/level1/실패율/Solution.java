class Solution {
	public int[] solution(int N, int[] stages) {
		int userNum = stages.length; //사용자 수
		int[] challenging = new int[N + 1]; //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
		int[] participant = new int[N + 1]; //스테이지에 도달한 플레이어 수
		double[] failureRate = new double[N + 1]; //실패율
		int[] answer = new int[N];

		for (int i = 0; i <= N; i++) {
			participant[i] = stages.length;
		}

		//challenging 정보 업데이트
		for (int i = 0; i < userNum; i++) {
			if (stages[i] <= N)
				challenging[stages[i]]++;
		}

		//participant 정보 업데이트
		for (int i = 2; i <= N; i++)
			participant[i] = participant[i - 1] - challenging[i - 1];

		//failure rate 업데이트
		for (int i = 1; i <= N; i++) {
			if (participant[i] != 0)
				failureRate[i] = (double) challenging[i] / participant[i];
			else failureRate[i] = 0;
		}
		failureRate[0] = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				if (failureRate[answer[i]] < failureRate[j])
					answer[i] = j;
				else continue;
			}
			failureRate[answer[i]] = -1;
		}

		return answer;
	}
}