package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ2644_촌수계산 {
	static int sum=0;
	static int[][] map;
	static boolean[]check;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		check=new boolean[N+1];
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			map[p][c]=1;
			map[c][p]=1;
		}
		dfs(a,b,0);
		System.out.println(sum==0?-1:sum);
	}
	private static void dfs(int a, int b, int cnt) {
		check[a]=true;
		if(a==b) {
			sum=cnt;
			return;
		}
		for(int i=1;i<=N;i++) {
			if(map[a][i]==1&&!check[i]) {
				dfs(i,b,cnt+1);
			}
		}
	}
}
