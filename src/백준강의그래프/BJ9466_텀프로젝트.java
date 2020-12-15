package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ9466_텀프로젝트 {
	static int[] arr;
	static boolean[] visit;
	static boolean[] done;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			int N=sc.nextInt();
			arr=new int[N+1];
			visit=new boolean[N+1];
			done=new boolean[N+1];
			cnt=0;
			for(int i=1;i<=N;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=1;i<=N;i++) {
				if(!done[i])
					dfs(i);
			}
			System.out.println(N-cnt);
		}
	}
	private static void dfs(int i) {
		if(!visit[i]) {
			visit[i]=true;
		}else {
			done[i]=true; cnt++; 
		}
		if(!done[arr[i]])
			dfs(arr[i]);
		visit[i]=false; done[i]=true;
	}
}
