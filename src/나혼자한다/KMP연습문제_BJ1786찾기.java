package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class KMP연습문제_BJ1786찾기 {
	static int[] Getpi(String pattern) {
		int j = 0;
		int[] pi = new int[pattern.length()];
		pi[0] = 0;
		for (int i = 1; i < pattern.length(); i++) {
			// 다르다면!
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// 같다면!
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = j + 1;
				j++;
			} 
//			else { 사실 필요가 없다. 기본적으로 생성될때 0으로 초기화 되어있어서..
//				pi[i] = 0;
//			}
		}
		return pi;
	}

		
	static StringBuilder sb=new StringBuilder();
	static int cnt=0;
	// result를 구할때 인덱스 정보가 1부터 시작하는듯.. +1을 해줘야합니다..
	static void Find(String origin, String pattern) {
		int j = 0;
		int[] pi = Getpi(pattern);
		for (int i = 0; i < origin.length(); i++) {
			// 다르면
			while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// 같다면
			if (origin.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					// 여기서 패턴 찾았으니까, 이 위치좌표 리스트에 넣고.
					// i위치까지 일치하는데 길이는 pattern.length만큼전부터 시작한거고! index=0부터라+1 length빼면 시작전index니까+1
					cnt++;
					sb.append(i - pattern.length() + 2).append(' ');
					// 지금까지 찾은건 위치에 넣었으니까 다음으로 갈때 초기화해놓고 가야지?
					j = pi[j];
					// 이부분에서 j는 pi[j-1]로 가는것이 아니다. 왜냐하면 j는 일치하는 위치에 있으니까!
				} else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String origin = sc.nextLine();
		String pattern = sc.nextLine();
		Find(origin, pattern);
		System.out.println(cnt);
		System.out.println(sb);
	}
}
