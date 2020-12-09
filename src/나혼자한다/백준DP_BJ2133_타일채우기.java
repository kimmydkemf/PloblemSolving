package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준DP_BJ2133_타일채우기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long [] dp =new long[31];
		dp[0]=1;
		dp[1]=0;
		for(int i=2;i<=N;i++) {
			if(i%2!=0)
				dp[i]=0;
			else {
				dp[i]=dp[i-2]*3;
				for(int j=2;j*2<=i;j++) {
					dp[i]+=dp[i-j*2]*2;
				}
//				dp[i]=dp[i-2]*3+2;
			}
		}
		System.out.println(dp[N]);
	}
}
