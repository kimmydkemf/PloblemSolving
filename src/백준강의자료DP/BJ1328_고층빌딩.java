package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1328_고층빌딩 {
	static long[][][] build;
	static long mod=1000000007;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int L=sc.nextInt();
		int R=sc.nextInt();
		build=new long[N+1][L+1][R+1];
		build[1][1][1]=1;
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=L;j++) {
				for(int k=1;k<=R;k++) {
					build[i][j][k]=build[i-1][j-1][k]+build[i-1][j][k-1]+build[i-1][j][k]*(i-2);
					build[i][j][k]%=mod;
				}
			}
		}
		System.out.println(build[N][L][R]);
	}
}
