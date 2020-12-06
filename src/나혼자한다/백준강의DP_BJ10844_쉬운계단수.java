package 나혼자한다;

import java.util.*;
public class 백준강의DP_BJ10844_쉬운계단수 { 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long dp[][]=new long[101][10];
		long mod=1000000000;
		for(int i=1;i<=9;i++)
			dp[1][i]=1;
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				dp[i][j]=0;
				if(j-1>=0) dp[i][j]+=dp[i-1][j-1];
				if(j+1<=9) dp[i][j]+=dp[i-1][j+1];
				dp[i][j]%=mod;
			}
		}
		long result=0;
		for(int i=0;i<=9;i++) {
			result+=dp[N][i];
		}
		System.out.println(result%mod);
	}
}
