package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1932_정수삼각형 {
	static int [][]map;
	static int [][]dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		map=new int[N+1][N+1];
		dp=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				map[i][j]=sc.nextInt();
				dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+map[i][j];
			}
		}
		int min=0;
		for(int i=0;i<=N;i++) 
			min=Math.max(min,dp[N][i]);
		System.out.println(min);
	}
}
