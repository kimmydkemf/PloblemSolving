package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ13301_타일장식물 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long dp[]=new long[N+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println((dp[N]+dp[N-1])*2);
	}
}
