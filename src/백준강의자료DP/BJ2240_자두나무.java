package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2240_자두나무 {
	static int[] tree;
	static int[][] dp;
	static int W,T;
	static boolean[][]check;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt(); W=sc.nextInt();
		tree=new int[T+1];
		dp=new int[T+1][W+1];
		check=new boolean[T+1][W+1];
		for(int i=1;i<=T;i++)
			tree[i]=sc.nextInt();
		System.out.println(Math.max(go(1,0),go(1,1)));
	}
	static int go(int time,int w) {
		if(time==T+1&&w<=W) return 0;
		if(w>W) return 0;
		if(check[time][w]) return dp[time][w];
		check[time][w]=true;
		int where=w%2+1;
		dp[time][w]=Math.max(go(time+1,w+1),go(time+1,w))+((where==tree[time])?1:0);
		return dp[time][w];
	}
}
