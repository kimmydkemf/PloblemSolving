package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int a[]=new int[N+1];
		long dp[]=new long[N+1];
		a[0]=0;dp[0]=0;
		a[1]=sc.nextInt();dp[1]=a[1];
		if(N>1) {
			a[2]=sc.nextInt();dp[2]=a[1]+a[2];
		}
		for(int i=3;i<=N;i++) {
			a[i]=sc.nextInt();
			dp[i]=Math.max(dp[i-3]+a[i-1],dp[i-2])+a[i];
		}
		System.out.println(dp[N]);
	}
}
