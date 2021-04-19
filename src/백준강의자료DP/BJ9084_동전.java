package 백준강의자료DP;

import java.util.*;
import java.io.*;

public class BJ9084_동전 {
	static int TC, N, M;
	static int dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(br.readLine());
			dp = new int[N + 1][M + 1];
			dp[0][0] = 1;
			for (int i = 1; i <= N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				for (int j = 0; j <= M; j++) {
					if (j < temp) {
						dp[i][j] = dp[i - 1][j];
					}else {
						dp[i][j]=dp[i][j-temp]+dp[i-1][j];
					}
				}
			}
			sb.append(dp[N][M]+"\n");
		}
		System.out.println(sb.toString());
	}
}
