package 프로그래머스LEVEL1;

public class 카카오1차비밀지도 {
	class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = n - 1; j >= 0; j--) {
					if ((arr1[i] & (1 << j)) == 0 && (arr2[i] & (1 << j)) == 0) {
						sb.append(" ");
					} else {
						sb.append("#");
					}
				}
				answer[i] = sb.toString();
			}
			return answer;
		}
	}
}
