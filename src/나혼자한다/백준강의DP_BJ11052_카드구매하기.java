package 나혼자한다;
import java.util.*;

public class 백준강의DP_BJ11052_카드구매하기 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int []p=new int[N+1];
		long []dp=new long [N+1];
		for(int i=1;i<=N;i++) {
			p[i]=sc.nextInt();
			dp[i]=p[i];
			for(int j=1;j<=i;j++) {
				dp[i]=Math.max(dp[i],dp[i-j]+p[j]);
			}
		}
		System.out.println(dp[N]);
	}

}
