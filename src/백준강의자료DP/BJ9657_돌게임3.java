package 백준강의자료DP;
import java.util.*;

public class BJ9657_돌게임3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		boolean dp[]=new boolean[1001];
		// 5,6 true 7 false, 8 true 2,7,9   
		for(int i=1;i<=1000;i++) {
			if(i%7==2||i%7==0) dp[i]=false;
			else dp[i]=true;
		}
		System.out.println(dp[N]?"SK":"CY");
	}
}
