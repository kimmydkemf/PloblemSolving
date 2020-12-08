package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		long[][] dp=new long[N][3];
		int s1=Integer.parseInt(br.readLine());
		dp[0][0]=0;
		dp[0][1]=s1;
		dp[0][2]=s1;
		if(N>1) {
			s1=Integer.parseInt(br.readLine());
			dp[1][0]=dp[0][2];
			dp[1][1]=dp[0][0]+s1;
			dp[1][2]=dp[0][1]+s1;
		}
		for(int i=2;i<N;i++) {
			s1=Integer.parseInt(br.readLine());
			long max=Math.max(dp[i-1][0],dp[i-1][2]);
			dp[i][0]=Math.max(max,dp[i-1][1]);
			dp[i][1]=dp[i-1][0]+s1;
			dp[i][2]=dp[i-1][1]+s1;
		}
		long result=Math.max(dp[N-1][0],dp[N-1][1]);
		result=Math.max(result,dp[N-1][2]);
		System.out.println(result);
	}
}
