package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1149_RGB거리 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int dp[][]=new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int now=Integer.parseInt(st.nextToken());
				int min=Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
				dp[i][j]=now+min;
			}
		}
		int result=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			result=Math.min(dp[N][i],result);
		}
		System.out.println(result);
	}
}
