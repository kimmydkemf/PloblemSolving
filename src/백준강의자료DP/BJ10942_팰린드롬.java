package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ10942_팰린드롬 {
	static int [][]dp;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		dp=new int[N+1][N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		for(int i=N;i>=1;i--) {
			for(int j=i;j<=N;j++) {
				if(i==j) {
					dp[i][j]=1;
					continue;
				}
				if((j-i)%2==1) {
					if(j>i+1) {						
						if(arr[i]==arr[j]&&dp[i+1][j-1]==1) {
							dp[i][j]=1;
						}else
							dp[i][j]=0;
					}else if(arr[i]==arr[j]) {
						dp[i][j]=1;
					}else {
						dp[i][j]=0;
					}
				}
				else {
					if(arr[i]==arr[j]&&dp[i+1][j-1]==1) {
						dp[i][j]=1;
					}else
						dp[i][j]=0;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()); int e=Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]+"\n");
		}
		System.out.println(sb.toString());
	}
}
