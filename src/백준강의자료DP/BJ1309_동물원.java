package 백준강의자료DP;
import java.util.*;

public class BJ1309_동물원 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	int dp[]=new int[N];
	if(N<=2) {
		if(N==1) System.out.println(3);
		else System.out.println(7);
	}else {
		dp[0]=3;
		dp[1]=7;
		for(int i=2;i<N;i++) {
			dp[i]=(dp[i-1]*2+dp[i-2])%9901;
		}
		System.out.println(dp[N-1]);
	}
}
}
