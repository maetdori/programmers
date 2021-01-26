class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[][] matrix1 = new int[n][n];
		int[][] matrix2 = new int[n][n];

		for (int i = 0; i < n; i++) {
			matrix1[i] = decToBin(arr1[i], n);
			matrix2[i] = decToBin(arr2[i], n);
		}

		for (int i = 0; i < n; i++) {
			answer[i] = "";
			for (int j = 0; j < n; j++) {
				if (matrix1[i][j] == 1 || matrix2[i][j] == 1)
					answer[i] += "#";
				else answer[i] += " ";
			}
		}

		return answer;
	}

	public int[] decToBin(int decVal, int n) {
		int[] bin = new int[n];
		int tmp = decVal;
		int q = 0;
		int r = 0;
		for (int i = n - 1; i >= 0; i--) {
			q = tmp / 2;
			r = tmp % 2;
			tmp /= 2;
			bin[i] = r;
		}
		return bin;
	}
}