package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ11066_파일합치기 {
	static int[][]dp;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr=new int[N];
			dp=new int[N][N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++) {
				for(int j=i;j>=0;j--) {
					if(i==j)
						dp[i][j]=0;
					else {
						int sum=0;
						for(int k=j;k<=i;k++) {
							sum+=arr[k];
						}
						int min=Integer.MAX_VALUE;
						for(int k=j;k<i;k++) {
								min=Math.min(min,dp[k][j]+dp[i][k+1]);
						}
						dp[i][j]=sum+min;
					}
				}
			}
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			sb.append(dp[N-1][0]+"\n");
		}
		System.out.println(sb.toString());
	}
}
