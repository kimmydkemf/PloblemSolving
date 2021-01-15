package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ11049_행렬곱셈순서 {
	static int arr[][];
	static int dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N][2];
		dp=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());arr[i][1]=Integer.parseInt(st.nextToken());
		}
		go(0,N-1);
		System.out.println(dp[0][N-1]);
	}
	static int go(int x,int y) {
		if(dp[x][y]!=0) return dp[x][y];
		if(x==y)
			return 0;
		if(x+1==y) {
			return arr[x][0]*arr[x][1]*arr[y][1];
		}
		dp[x][y]=-1;
		for(int k=x;k<=y-1;k++) {
			int t1=go(x,k);
			int t2=go(k+1,y);
			int ans=t1+t2+arr[x][0]*arr[k][1]*arr[y][1];
			if(dp[x][y]==-1||dp[x][y]>ans)
				dp[x][y]=ans;
		}
		return dp[x][y];
	}
}
