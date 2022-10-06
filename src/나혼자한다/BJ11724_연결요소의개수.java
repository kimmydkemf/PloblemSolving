package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11724_연결요소의개수 {
	static boolean[] check;
	static int[][]arr;
	static int N,M,answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;
			arr[b][a]=1;
		}
		answer=0;
		check=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			if(check[i]) continue;
			dfs(i,0);
			answer++;
		}
		System.out.println(answer);
	}
	static void dfs(int now,int cnt) {
		check[now]=true;
		for(int i=1;i<=N;i++) {
			if(check[i]) continue;
			if(arr[now][i]==1) {
				dfs(i,cnt+1);
			}
		}
	}
}
