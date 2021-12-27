package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2666_벽장문의이동 {
	static int dp[][][];
	static int open[];
	static int N,tc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		tc=Integer.parseInt(br.readLine());
		
		dp=new int[tc+1][N+1][N+1];
		
		for(int i=0;i<=tc;i++) 
			for(int j=0;j<=N;j++) Arrays.fill(dp[i][j],-1);
		
		open=new int[tc+1];
		for(int i=1;i<=tc;i++) {
			open[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(move(1,a,b));
//		for(int i=0;i<=tc;i++) {
//			for(int j=0;j<=N;j++) {
//				for(int k=0;k<=N;k++) {
//					System.out.print(dp[i][j][k]);
//				}
//				System.out.println();
//			}
//		}
	}
	public static int move(int step,int a,int b) {
		if(step>tc) return 0;
		if(dp[step][a][b]!=-1) return dp[step][a][b];
		return dp[step][a][b]=Math.min(Math.abs(a-open[step])+move(step+1,b,open[step]),
				Math.abs(b-open[step])+move(step+1,a,open[step]));
	}
}
