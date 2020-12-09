package 나혼자한다;

import java.util.*;
import java.io.*;

public class 백준DP_BJ2225_합분해 {
	static long mod=1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] dp = new long[201][201];
		dp[0][0]=1;
		for (int i = 1; i <=K; i++) {
			for (int j = 0; j <= N; j++) {
					for (int k = 0; k <= j; k++) {
						dp[i][j] += dp[i - 1][j - k];
						dp[i][j]%=mod;
					}
				}
		}
		System.out.println(dp[K][N]);
	}
}
