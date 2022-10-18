package 나혼자한다;

import java.util.Scanner;

public class BJ11055_BJ가장큰증가부분수열 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		int dp[]=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
			dp[i]=arr[i];
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], arr[i]+dp[j]);
				}
			}
		}
		int max=0;
		for(int i=0;i<N;i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
