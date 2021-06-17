package 백준강의완전탐색;
import java.util.*;

public class BJ15652_N과M4 {
	static int N,M;
	static StringBuilder sb;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[M];
		sb=new StringBuilder();
		dfs(1,0);
		System.out.println(sb.toString());
	}
	static void dfs(int idx,int cnt){
		if(idx>N+1) return;
		if(cnt==M) {
			for(int i=0;i<M;i++)
				sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		for(int i=idx;i<=N;i++) {
			arr[cnt]=i;
			dfs(i,cnt+1);
		}
	}
}