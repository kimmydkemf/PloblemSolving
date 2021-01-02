package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ10891_차이를최대로 {
	static int max,N;
	static int []A;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		A=new int[N];
		visit=new boolean[N];
		for(int i=0;i<N;i++)
			A[i]=sc.nextInt();
		max=Integer.MIN_VALUE;
		recursion(0,new int[N]);
		System.out.println(max);
	}
	static void recursion(int cnt,int[] arr) {
		if(cnt==N) {
			int sum=0;
			for(int i=0;i<N-1;i++) {
				sum+=Math.abs((arr[i]-arr[i+1]));
			}
			max=Math.max(max,sum);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visit[i])
				continue;
			visit[i]=true;
			arr[cnt]=A[i];
			recursion(cnt+1,arr);
			visit[i]=false;
		}
	}
}
