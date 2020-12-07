package 나혼자한다;
import java.util.*;

public class 백준강의DP_11057_오르막수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long dp[][]=new long[N+1][10];
		for(int i=0;i<=9;i++)
			dp[1][i]=1;
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j]+=dp[i-1][k];
					dp[i][j]%=10007;
				}
			}
		}
		long result=0;
		for(int i=0;i<10;i++) {
			result+=dp[N][i];
		}
		System.out.println(result%10007);
	}
}
