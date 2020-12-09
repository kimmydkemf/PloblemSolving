package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ1912_연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int dp[][]=new int[N][2];
		dp[0][0]=Integer.parseInt(st.nextToken());
		dp[0][1]=Integer.MIN_VALUE;
		for(int i=1;i<N;i++) {
			int now=Integer.parseInt(st.nextToken());
			dp[i][0]=Math.max(dp[i-1][0]+now,now);
			dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
		}
		System.out.println(Math.max(dp[N-1][0],dp[N-1][1]));
	}
}
