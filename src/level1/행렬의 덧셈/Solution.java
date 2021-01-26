class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int rowSize = arr1.length;
		int colSize = arr1[0].length;
		int[][] answer = new int[rowSize][colSize];

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}
}