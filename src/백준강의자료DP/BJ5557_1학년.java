package 백준강의자료DP;

import java.util.*;
import java.io.*;

public class BJ5557_1학년 {
	static long dp[][];
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 3<=N<=100;
		N-=1;
		dp = new long[N][21];
		arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());
		dp[0][arr[0]]=1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 21; j++) {
				if (j + arr[i] <= 20) {
					dp[i][j] += dp[i-1][j+arr[i]];
				}
				if (j - arr[i]>= 0) {
					dp[i][j] += dp[i-1][j-arr[i]];
				}
			}
		}
		System.out.println(dp[N - 1][last]);
	}
}
