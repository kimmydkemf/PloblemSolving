package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ2583_영역구하기 {
	static int[][]map;
	static boolean[][]visit;
	static int N,M;
	static PriorityQueue<Integer> queue;
	static int di[]= {-1,0,1,0};
	static int dj[]= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int ldx=Integer.parseInt(st.nextToken());
			int ldy=Integer.parseInt(st.nextToken());
			int rux=Integer.parseInt(st.nextToken())-1;
			int ruy=Integer.parseInt(st.nextToken())-1;
			for(int j=ldy;j<=ruy;j++) {
				for(int k=ldx;k<=rux;k++) {
					map[k][j]=1;
				}
			}
		}
		queue=new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[j][i]&&map[j][i]==0) {
					queue.add(bfs(j,i));
				}
			}
		}
		System.out.println(queue.size());
		while(!queue.isEmpty()) {
			System.out.print(queue.poll()+" ");
		}
	}
	static int bfs(int j,int i) {
		int cnt=0;
		visit[j][i]=true;
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(j,i));
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			cnt++;
			for(int d=0;d<4;d++) {
				int nx=now.x+di[d];
				int ny=now.y+dj[d];
				if(isIn(nx,ny)&&!visit[nx][ny]&&map[nx][ny]==0) {
					visit[nx][ny]=true;
					queue.add(new Point(nx,ny));
				}
			}
		}
		return cnt; 
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	static class Point{
		int x, y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
