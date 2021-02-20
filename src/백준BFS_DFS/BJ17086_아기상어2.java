package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ17086_아기상어2 {
	static int N,M;
	static int[][] map;
	static boolean[][][] visit;
	static int di[]= {-1,-1,-1,0,0,1,1,1};
	static int dj[]= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		Queue<Point> queue=new LinkedList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int temp=Integer.parseInt(st.nextToken());
				if(temp==0)
					map[i][j]=Integer.MAX_VALUE;
				else {
					map[i][j]=0;
					queue.add(new Point(i,j,0));
				}
			}
		}
		visit=new boolean[N][M][queue.size()];
		bfs(queue);
		int result=findmap();
		System.out.println(result);
	}
	static void bfs(Queue<Point> queue) {
		int size=queue.size();
		for(int i=0;i<size;i++) {
			Point start = queue.poll();
			visit[start.x][start.y][i]=true;
			Queue<Point> gq=new LinkedList<Point>();
			gq.add(start);
			while(!gq.isEmpty()) {
				Point now=gq.poll();
				if(map[now.x][now.y]>now.length)
					map[now.x][now.y]=now.length;
				for(int d=0;d<8;d++) {
					int nx=di[d]+now.x;
					int ny=dj[d]+now.y;
					if(isIn(nx,ny)&&!visit[nx][ny][i]) {
						visit[nx][ny][i]=true;
						gq.add(new Point(nx,ny,now.length+1));
					}
				}
			}
		}
	}
	static int findmap() {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cnt=Math.max(map[i][j],cnt);
			}
		}
		return cnt;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	static class Point{
		int x,y;
		int length;
		Point(int x,int y,int l){
			this.x=x;
			this.y=y;
			this.length=l;
		}
	}
}
