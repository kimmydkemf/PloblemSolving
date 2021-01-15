package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2228_구간나누기 {
	static int arr[];
	static int dp[][];
	static boolean c[][];
	static int s[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());
		arr=new int[N+1];
		dp=new int[N+1][M+1];
		c=new boolean[N+1][M+1];
		s=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			s[i]=s[i-1]+arr[i];
		}
		System.out.println(go(N,M));
	}
	static int go(int n,int m) {
		if(m==0) return 0;
		if(n<=0) return -193103103;
		if(c[n][m]) return dp[n][m];
		c[n][m]=true;
		dp[n][m]=go(n-1,m);
		for(int i=1;i<=n;i++) {
			int temp=go(i-2,m-1)+s[n]-s[i-1];
			dp[n][m]=Math.max(dp[n][m],temp);
		}
		return dp[n][m];
	}
}
