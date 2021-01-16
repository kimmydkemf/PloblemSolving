package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1720_타일코드 {
	static long dp[];
	static long dp2[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new long[N+1];
		dp2=new long[N+1];
		if(N==1) {
			System.out.println(1);
			return;
		}else if(N==2) {
			System.out.println(3);
			return;
		}
		dp[1]=1;dp[2]=3;
		for(int i=3;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-2]*2;
		}
		dp2[1]=1;dp2[2]=3;
		for(int i=3;i<=N;i++) {
			long b=0;
			if(i%2==1) b=dp[(i-1)/2];
			else b=dp[i/2]+2*dp[(i-2)/2];
			dp2[i]=(dp[i]+b)/2;
		}
		System.out.println(dp2[N]);
	}
}
