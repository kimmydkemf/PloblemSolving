package 백준강의자료DP;
import java.util.*;

public class BJ3067_Coins {
	static int [] coins;
	static int [][] dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int N=sc.nextInt();
			coins=new int[N];
			for(int i=0;i<N;i++) coins[i]=sc.nextInt();
			int M=sc.nextInt();
			dp=new int[N][M+1];
			Arrays.sort(coins);
			for(int i=0;i<N;i++) {
				dp[i][0]=1;
				for(int j=1;j<=M;j++) {
					if(i==0) {
						if(j%coins[i]==0) dp[i][j]=1;
					}else {
						if(coins[i]>j) dp[i][j]=dp[i-1][j];
						else dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
					}
				}
			}
			sb.append(dp[N-1][M]+"\n");
		}
		System.out.println(sb.toString());
	}
}
