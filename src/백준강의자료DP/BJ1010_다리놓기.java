package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1010_다리놓기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine()); // N<=M=30;
		long dp[][]=new long[31][31];
		for(int i=1;i<=30;i++) {
			for(int j=1;j<=30;j++) {
				if(i>j) continue;
				if(i==j) dp[i][j]=1;
				else {
					if(i==1) {
						dp[i][j]=j;
					}
					for(int k=j-1;k>=i-1;k--) {
						dp[i][j]+=dp[i-1][k];
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			sb.append(dp[n][m]+"\n");
		}
		System.out.println(sb.toString());
	}
}
