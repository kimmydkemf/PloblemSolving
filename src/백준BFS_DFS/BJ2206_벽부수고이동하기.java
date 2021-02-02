package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ2206_벽부수고이동하기 {
	static int N,M;
	static int di[]= {-1,0,1,0};
	static int dj[]= {0,-1,0,1};
	static int map[][];
	static boolean check[][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		check=new boolean[N][M][2];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		int result = bfs();
		System.out.println(result);
	}
	static int bfs() {
		int cnt=1;
		check[0][0][0]=true;
		Queue<Point> queue=new LinkedList<Point>();
		queue.add(new Point(0,0,0));
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				Point now=queue.poll();
				if(now.x==N-1&&now.y==M-1) {
					return cnt;
				}
				for(int d=0;d<4;d++) {
					int nx=now.x+di[d];
					int ny=now.y+dj[d];
					if(isIn(nx,ny)) {
						if(map[nx][ny]==1) {
							if(now.wall==0) {
								check[nx][ny][1]=true;
								queue.add(new Point(nx,ny,1));
							}
						}else if(!check[nx][ny][now.wall]) {
							check[nx][ny][now.wall]=true;
							queue.add(new Point(nx,ny,now.wall));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	static class Point{
		int x,y;
		int wall;
		Point(int x,int y,int wall){
			this.x=x;
			this.y=y;
			this.wall=wall;
		}
	}
}
