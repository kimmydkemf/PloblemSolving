package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ11048_이동하기 {
	static int map[][];
	static int dp[][];
	static boolean visit[][];
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
		map= new int[N][M];
		dp=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=map[0][0];
		go(0,0);
		System.out.println(dp[N-1][M-1]);
	}
	static void go(int x,int y) {
		visit[x][y]=true;
		Queue<Node> queue=new LinkedList<>();
		queue.add(new Node(x,y));
		while(!queue.isEmpty()) {
			Node now=queue.poll();
			dp[now.x][now.y]=map[now.x][now.y];
			if(now.x>0&&now.x<N) {
				dp[now.x][now.y]=Math.max(dp[now.x][now.y],map[now.x][now.y]+dp[now.x-1][now.y]);
			}
			if(now.y>0&&now.y<M) {
				dp[now.x][now.y]=Math.max(dp[now.x][now.y],map[now.x][now.y]+dp[now.x][now.y-1]);
			}
			if(now.x>0&&now.x<N&&now.y>0&&now.y<M) {
				dp[now.x][now.y]=Math.max(dp[now.x][now.y],map[now.x][now.y]+dp[now.x-1][now.y-1]);
			}
			if(now.y+1<M&&!visit[now.x][now.y+1]) {
				queue.add(new Node(now.x,now.y+1));
				visit[now.x][now.y+1]=true;
			}
			if(now.x+1<N&&!visit[now.x+1][now.y]) {
				queue.add(new Node(now.x+1,now.y));
				visit[now.x+1][now.y]=true;
			}
			if(now.y+1<M&&now.x+1<N&&!visit[now.x+1][now.y+1]) {
				queue.add(new Node(now.x+1,now.y+1));
				visit[now.x+1][now.y+1]=true;
			}
		}
	}
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
