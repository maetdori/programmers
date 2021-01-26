class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		int[] score = new int[3]; //3번의 score를 저장할 배열
		int idx = 0; //저장할 score 배열의 index

		for (int i = 0; i < dartResult.length(); i++) {
			char ch0 = dartResult.charAt(i);

			if ('0' <= ch0 && ch0 <= '9') {
				char ch1 = dartResult.charAt(++i); //현재문자의 다음문자

				//score==10인 경우
				if (ch1 == '0') {
					score[idx] = 10;
					ch1 = dartResult.charAt(++i);
				}

				//score<10인 경우
				else score[idx] = Character.getNumericValue(ch0);

				switch (ch1) {
					case 'D':
						score[idx] *= score[idx];
						System.out.println("D" + score[idx]);
						break;
					case 'T':
						score[idx] *= score[idx] * score[idx];
						System.out.println("T" + score[idx]);
						break;
					default:
						System.out.println("S" + score[idx]);
						break;
				}
				idx++;
			} else if (ch0 == '*') {
				score[idx - 1] *= 2;
				if (idx != 1)
					score[idx - 2] *= 2;
			} else if (ch0 == '#') {
				score[idx - 1] *= -1;
			}

			for (int k = 0; k < 3; k++) {
				System.out.print(score[k] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < 3; i++) {
			answer += score[i];
		}

		return answer;
	}
}