package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465_스티커 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int n=Integer.parseInt(br.readLine());
			int arr[][]=new int[2][n+1];
			int dp[][]=new int[2][n+1];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[0][i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[1][i]=Integer.parseInt(st.nextToken());
			}
			dp[0][1]=arr[0][1];
			dp[1][1]=arr[1][1];
			for(int i=2;i<=n;i++) {
				// 어쨋든 지금 선택.
				dp[0][i]=Math.max(dp[1][i-1], dp[0][i-2])+arr[0][i];
				dp[1][i]=Math.max(dp[0][i-1], dp[1][i-2])+arr[1][i];
				// 선택 안함.
				dp[0][i]=Math.max(dp[0][i], dp[0][i-1]);
				dp[1][i]=Math.max(dp[1][i], dp[1][i-1]);
			}
			int result1=Math.max(dp[0][n], dp[1][n]);
			int result2=Math.max(dp[0][n-1], dp[1][n-1]);
			sb.append(Math.max(result1,result2)+"\n");
		}
		System.out.println(sb.toString());
	}
}
