package 백준강의자료DP;
import java.util.*;

public class BJ2748_피보나치수2 {
	static long dp[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		dp=new long[91];
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;
		for(int i=3;i<=90;i++) dp[i]=dp[i-1]+dp[i-2];
		int N=sc.nextInt();
		System.out.println(dp[N]);
	}
}
