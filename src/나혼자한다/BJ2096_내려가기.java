package 나혼자한다;

import java.util.Scanner;

public class BJ2096_내려가기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [][]arr=new int[N][3];
		int [][]dp=new int[N][3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				if(i==0) {
					dp[i][j]=arr[i][j];
				}
				else {
					if(j==0) {
						dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j+1])+arr[i][j];
					}else if(j==1) {
						dp[i][j]=arr[i][j]+Math.max(dp[i-1][j-1], Math.max(dp[i-1][j],dp[i-1][j+1]));
					}else {
						dp[i][j]=arr[i][j]+Math.max(dp[i-1][j], dp[i-1][j+1]);
					}
				}
			}
		}
		System.out.println(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2])));
	}
}
