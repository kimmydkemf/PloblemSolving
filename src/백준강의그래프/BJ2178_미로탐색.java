package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ2178_미로탐색 {
	static int[][] map;
	static boolean[][] visit;
	static int N,M;
	static int []di= {-1,0,1,0};
	static int[]dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0;i<N;i++) {
			String line=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++)
//				System.out.print(map[i][j]);
//			System.out.println();
//		}
		// 0,0 에서 N-1, M-1 까지 가는 최단경로
		System.out.println(bfs(new Point(0,0)));
	}
	static int bfs(Point start) {
		int cnt=1;
		Queue<Point> queue=new LinkedList<>();
		queue.add(start);
		visit[start.x][start.y]=true;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				Point now = queue.poll();
				if(now.x==N-1&&now.y==M-1)
					return cnt;
				for(int j=0;j<4;j++) {
					int ni=di[j]+now.x;
					int nj=dj[j]+now.y;
					if(isIn(ni,nj)&&map[ni][nj]==1&&!visit[ni][nj]) {
						visit[ni][nj]=true;
						queue.add(new Point(ni,nj));
					}
				}
			}
			cnt++;
		}
		return 0;
	}
	static boolean isIn(int i,int j) {
		return (i>=0&&i<N&&j>=0&&j<M)?true:false;
	}
	static class Point{
		int x,y;
		Point(int i,int j){
			x=i;
			y=j;
		}
	}
}
