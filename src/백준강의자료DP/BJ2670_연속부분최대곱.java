package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2670_연속부분최대곱 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		double dp[]=new double[N];
		dp[0]=sc.nextDouble();
		double max=dp[0];
		for(int i=1;i<N;i++) {
			double temp=sc.nextDouble();
			dp[i]=Math.max(temp, dp[i-1]*temp);
			max=Math.max(max,dp[i]);
		}
		System.out.printf("%.3f",max);
	}
}
