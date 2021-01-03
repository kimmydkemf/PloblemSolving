package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ10971_외판원순회2 {
	static int N,now;
	static boolean[] visit;
	static long min;
	static int[][]map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visit=new boolean[N];
		min=Long.MAX_VALUE;
		for(int i=0;i<N;i++) {
			now=i;
			dfs(i,1,0);
		}
		System.out.println(min);
	}
	static void dfs(int next,int cnt,long value) {
		if(next==now&&visit[next]) { // 출발지로 돌아옴.
			if(cnt==N+1) { // 다 방문하고 온경우.
				min=Math.min(min,value);
			}
			return;
		}
		if(visit[next]) {
			return;
		}
		visit[next]=true;
		for(int i=0;i<N;i++) {
			int nvalue=map[next][i];
			if(i!=next&&nvalue!=0) {
				dfs(i,cnt+1,value+nvalue);
			}
		}
		visit[next]=false;
		return;
	}
}
