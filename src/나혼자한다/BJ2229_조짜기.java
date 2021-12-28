package 나혼자한다;

import java.util.Scanner;

public class BJ2229_조짜기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[]dp=new int[N+1];
		int[]arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			for(int j=i;j>=0;j--) {
				int min=Integer.MAX_VALUE;
				int max=Integer.MIN_VALUE;
				for(int k=i;k>=j;k--) {
					min=Math.min(arr[k], min);
					max=Math.max(arr[k], max);
				}
				dp[i+1]=Math.max(dp[j]+max-min, dp[i+1]);
			}
		}
		System.out.println(dp[N]);
	}
}
