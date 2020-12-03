package 나혼자한다;

import java.util.Scanner;

public class 백준강의DP_BJ11726_Nx2타일링 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int DP[]=new int[1001];
		DP[1]=1;
		DP[2]=2;
		for(int i=3;i<=N;i++) {
			DP[i]=DP[i-1]+DP[i-2];
			DP[i]%=10007;
		}
		System.out.println(DP[N]);
	}
}
