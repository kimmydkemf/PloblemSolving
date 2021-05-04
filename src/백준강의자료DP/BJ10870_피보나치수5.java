package 백준강의자료DP;
import java.util.*;

public class BJ10870_피보나치수5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N==0) {
			System.out.println(0);
			return;
		}
		int []dp=new int[N+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<N+1;i++)
			dp[i]=dp[i-1]+dp[i-2];
		System.out.println(dp[N]);
	}
}
