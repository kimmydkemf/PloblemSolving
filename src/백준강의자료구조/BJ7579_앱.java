package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ7579_앱 {
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int []memo=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) memo[i]=Integer.parseInt(st.nextToken());
		int []cost=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) cost[i]=Integer.parseInt(st.nextToken());
		// 입력 완료.
		
		int dp[][]=new int[N][10001]; // 천만에 100 곱해도 10억이라 int 안에서 해결가능.
		int ncost=cost[0];
		int nmemo=memo[0];
		for(int i=ncost;i<=10000;i++) {
			dp[0][i]=nmemo;
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<=10000;j++) {
				if(j>=cost[i]) dp[i][j]=Math.max(dp[i-1][j-cost[i]]+memo[i],dp[i-1][j]);
				else dp[i][j]=dp[i-1][j];
			}
		}
		for(int i=0;i<=10000;i++) {
			if(dp[N-1][i]>=M) {
				System.out.println(i);
				return;
			}
		}
	}
}
