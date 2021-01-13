package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2293_동전1 {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt();
		int dp[] =new int[K+1];
		int arr[]=new int[N+1];
		for(int i=1;i<=N;i++)
			arr[i]=sc.nextInt();
		dp[0]=1;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				if(j>=arr[i]) {
					dp[j]+=dp[j-arr[i]];
				}
			}
		}
		System.out.println(dp[K]);
	}
}
