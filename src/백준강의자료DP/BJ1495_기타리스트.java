package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1495_기타리스트 {
	static int [][]dp;
	static int N,S,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); S=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
		dp=new int[N+1][M+1];
		st=new StringTokenizer(br.readLine());
		dp[0][S]=1;
		for(int n=1;n<=N;n++) {
			int now=Integer.parseInt(st.nextToken());
			for(int i=0;i<=M;i++) {
				if(dp[n-1][i]==1) {
					int temp=i;
					if(temp+now<=M) {
						dp[n][temp+now]=1;
					}
					if(temp-now>=0) {
						dp[n][temp-now]=1;
					}
				}
			}
		}
		for(int i=M;i>=0;i--) {
			if(dp[N][i]==1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
