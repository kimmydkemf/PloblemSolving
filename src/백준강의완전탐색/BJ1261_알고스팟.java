package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1261_알고스팟 {
	static int R,C;
	static int map[][];
	static int dp[][];
	static boolean[][] visit;
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new int[C][R];
		dp=new int[C][R];
		visit=new boolean[C][R];
		for(int i=0;i<C;i++) {
			String s=br.readLine();
			for(int j=0;j<R;j++)
				map[i][j]=s.charAt(j)-'0';
		}
		bfs();
//		for(int i=0;i<C;i++) {
//			for(int j=0;j<R;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(dp[C-1][R-1]);
	}
	static void bfs() {
		Queue<Point> queue=new LinkedList<>();
		Queue<Point> next_queue=new LinkedList<>();
		visit[0][0]=true;
		dp[0][0]=0;
		queue.add(new Point(0,0));
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=now.x+di[i];
				int ny=now.y+dj[i];
				if(isIn(nx,ny)&&!visit[nx][ny]) {
					visit[nx][ny]=true;
					if(map[nx][ny]==0) {
						dp[nx][ny]=dp[now.x][now.y];
						queue.add(new Point(nx,ny));
					}else {
						dp[nx][ny]=dp[now.x][now.y]+1;
						next_queue.add(new Point(nx,ny));
					}
				}
			}
			if(queue.isEmpty()) {
				queue=next_queue;
				next_queue=new LinkedList<>();
			}
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0&&x<C&&y>=0&&y<R;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
