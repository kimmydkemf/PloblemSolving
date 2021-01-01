package 백준강의완전탐색;

import java.util.*;
import java.io.*;

public class BJ1107_리모컨 {
	static boolean check[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int destroynum = sc.nextInt();
		check = new boolean[10];
		for (int i = 0; i < destroynum; i++)
			check[sc.nextInt()] = true;
		int result = Math.abs(N - 100); // +나 -로 이동할수 있는 값.
		for (int i = 0; i <= 1000000; i++) {
			int c = i;
			int length = find(c);
			if (length != 0) {
				result = Math.min(result, length + Math.abs((N - c)));
			}
		}
		System.out.println(result);
	}
	static int find(int n) {
		if (n == 0) {
			return check[0] ? 0 : 1;
		}
		int len = 0;
		while (n > 0) {
			if (check[n % 10])
				return 0;
			len += 1;
			n /= 10;
		}
		return len;
	}
}
