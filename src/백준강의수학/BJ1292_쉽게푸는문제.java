package 백준강의수학;

import java.util.*;

public class BJ1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		long sum = 0;
		int idx = 1;
		int cnt = 0;
		for (int i = 1; i < A; i++) {
			cnt++;
			if (cnt == idx) {
				idx++;
				cnt = 0;
			}
		}
		for (int i = A; i <= B; i++) {
			cnt++;
			sum += idx;
			if (cnt == idx) {
				idx++;
				cnt = 0;
			}
		}
		System.out.println(sum);
	}
}
