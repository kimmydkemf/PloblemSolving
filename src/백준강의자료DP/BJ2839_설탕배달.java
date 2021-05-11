package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2839_설탕배달 {
	static int dp[][]=new int[2][5001];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(dp[0],987654321);
		Arrays.fill(dp[1],987654321);
		dp[0][0]=0;dp[1][0]=0;
		for(int i=1;i<=5000;i++) if(i%3==0) dp[0][i]=i/3;
		for(int i=1;i<5;i++) dp[1][i]=dp[0][i];
		for(int i=5;i<=5000;i++) dp[1][i]=Math.min(Math.min(dp[1][i-5]+1,dp[0][i-5]+1),dp[0][i]);
		int N=Integer.parseInt(br.readLine());
		System.out.println(dp[1][N]==987654321?-1:dp[1][N]);
	}
}
