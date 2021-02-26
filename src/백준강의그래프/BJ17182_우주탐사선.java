package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ17182_우주탐사선 {
	static int N,K;
	static int map[][];
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
				}
			}
		}
		ans=Integer.MAX_VALUE;
		boolean[] visit=new boolean[N];
		visit[K]=true;
		dfs(visit,K,0,0);
		System.out.println(ans);
	}
	static void dfs(boolean[] visit,int start, int sum, int idx) {
		if(idx==N-1) {
			ans=Math.min(sum,ans);
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				dfs(visit,i,sum+map[start][i],idx+1);
				visit[i]=false;
			}
		}
	}
}
