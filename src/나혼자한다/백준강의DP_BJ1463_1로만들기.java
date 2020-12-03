package 나혼자한다;

import java.util.Scanner;

public class 백준강의DP_BJ1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int []dp=new int[N+1];
		dp[1]=0;
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+1;
			if(i%3==0&&dp[i]>dp[i/3]+1) {
				dp[i]=dp[i/3]+1;
			}
			if(i%2==0&&dp[i]>dp[i/2]+1) {
				dp[i]=dp[i/2]+1;
			}
		}
		System.out.println(dp[N]);
	}
}
