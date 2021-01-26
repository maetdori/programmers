class Solution {
	public String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			if ('a' <= ch && ch <= 'z')
				ch = (ch + n - 'a') % 26 + 'a';
			else if ('A' <= ch && ch <= 'Z')
				ch = (ch + n - 'A') % 26 + 'A';
			answer += (char) ch;
		}

		return answer;
	}
}