package 백준강의자료DP;

import java.util.*;
import java.io.*;

public class BJ9184_신나는함수실행 {
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		dp=new int[102][102][102];
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				for(int k=0;k<102;k++) {
					dp[i][j][k]=1048577;
				}
			}
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(a==-1&&b==-1&&c==-1) break;
			sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
		}
		System.out.println(sb.toString());
	}
	static int w(int a,int b,int c) {
		if(dp[a+50][b+50][c+50]!=1048577) {
			return dp[a+50][b+50][c+50];
		}
		if (a <= 0 || b <= 0 || c <= 0) {
			return dp[a+50][b+50][c+50]=1;
		}

		if( a > 20 || b > 20 || c > 20) {
			return dp[a+50][b+50][c+50]=w(20,20,20);
		}

		if(a < b && b < c)
		    return dp[a+50][b+50][c+50]=w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		else
		    return dp[a+50][b+50][c+50]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
}
