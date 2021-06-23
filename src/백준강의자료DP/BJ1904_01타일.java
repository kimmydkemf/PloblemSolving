package 백준강의자료DP;
import java.util.*;

public class BJ1904_01타일 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int dp[]=new int[1000001];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=1000000;i++)  dp[i]=(dp[i-1]+dp[i-2])%15746;
		int N=sc.nextInt();
		System.out.println(dp[N]%15746);
	}
}
