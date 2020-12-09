package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuffer sb=new StringBuffer();
		int TC=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=TC;tc++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			StringTokenizer arr1=new StringTokenizer(br.readLine());
			StringTokenizer arr2=new StringTokenizer(br.readLine());
			int [][]stiker=new int[N][2];
			for(int i=0;i<N;i++) {
				stiker[i][0]=Integer.parseInt(arr1.nextToken());
				stiker[i][1]=Integer.parseInt(arr2.nextToken());
			}
			long [][]dp=new long[N][2];
			dp[0][0]=stiker[0][0];
			dp[0][1]=stiker[0][1];
			if(N>=2) {
				dp[1][0]=dp[0][1]+stiker[1][0];
				dp[1][1]=dp[0][0]+stiker[1][1];
			}
			for(int i=2;i<N;i++) {
				dp[i][0]=Math.max(dp[i-1][1]+stiker[i][0], dp[i-2][1]+stiker[i][0]);
				dp[i][1]=Math.max(dp[i-1][0]+stiker[i][1],dp[i-2][0]+stiker[i][1]);
			}
			long result=Math.max(dp[N-1][0],dp[N-1][1]);
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
}
