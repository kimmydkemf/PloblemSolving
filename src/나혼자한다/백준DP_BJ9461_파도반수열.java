package 나혼자한다;

import java.util.*;
import java.io.*;

public class 백준DP_BJ9461_파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			long dp[] = new long[101];
			int N = sc.nextInt();
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5]=2;
			for (int i = 6; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 5];
			}
			System.out.println(dp[N]);
		}
	}
}
