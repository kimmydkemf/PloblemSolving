package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2302_극장좌석 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int dp[]=new int[N+1];
		int M=sc.nextInt();
		if(N==1) {
			System.out.println(1);
			return;
		}
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=N;i++) dp[i]=dp[i-1]+dp[i-2];
		int answer=1;
		int start=0;
		for(int i=1;i<=M;i++) {
			int stop=sc.nextInt();
			answer*=dp[stop-start-1];
			start=stop;
		}
		answer*=dp[N-start];
		System.out.println(answer);
	}
}
