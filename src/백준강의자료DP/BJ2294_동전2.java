package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2294_동전2 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt();
		int dp[]=new int[K+1];
		dp[0]=0;
		for(int i=1;i<=K;i++)
			dp[i]=-1;
		int arr[]=new int[N+1];
		for(int i=1;i<=N;i++)
			arr[i]=sc.nextInt();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(j>=arr[i]) {
					if(dp[j-arr[i]]==-1) {
						continue;
					}
					int temp=dp[j-arr[i]]+1;
					if(dp[j]==-1) {
						dp[j]=temp;
					}else
						dp[j]=Math.min(temp,dp[j]);
				}
			}
		}
		System.out.println(dp[K]);
	}
}
