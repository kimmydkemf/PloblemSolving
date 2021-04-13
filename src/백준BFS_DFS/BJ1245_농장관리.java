package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ1245_농장관리 {
	static int N,M;
	static int[][]map;
	static boolean[][] visit;
	static int []di= {-1,-1,-1,0,0,1,1,1};
	static int []dj= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]) {
					cnt+=bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
	}
	static int bfs(int x,int y) {
		boolean check=false;
		visit[x][y]=true;
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(x,y));
		int start=map[x][y];
		while(!q.isEmpty()) {
			Point now=q.poll();
			for(int i=0;i<8;i++) {
				int nx=now.x+di[i];
				int ny=now.y+dj[i];
				if(isIn(nx,ny)) {
					if(map[nx][ny]>start) {
						check=true;
						continue;
					}else if(!visit[nx][ny]&&map[nx][ny]==start) {
						visit[nx][ny]=true;
						q.add(new Point(nx,ny));
					}
				}
			}
		}
		if(!check) return 1;
		return 0;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
