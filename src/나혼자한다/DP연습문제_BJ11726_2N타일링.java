package 나혼자한다;

import java.util.Scanner;

public class DP연습문제_BJ11726_2N타일링 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[]memo=new int[1001];
		memo[1]=1;
		memo[2]=2;
		for(int i=3;i<=N;i++) 
			memo[i]=(memo[i-1]+memo[i-2])%10007;
		System.out.println(memo[N]%10007);
	}
}
