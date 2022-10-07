package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_미로탐색 {
	static int N,M;
	static int[][]map;
	static boolean[][]check;
	static int [] di= {-1,0,1,0};
	static int [] dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		check=new boolean[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		bfs();
	}
	private static void bfs() {
		Point start=new Point(0,0,1);
		check[0][0]=true;
		Queue<Point> q=new LinkedList();
		q.add(start);
		while(!q.isEmpty()) {
			Point now=q.poll();
			if(now.x==N-1&&now.y==M-1) {
				System.out.println(now.c);
				return;
			}
			for(int i=0;i<4;i++) {
				int ni=di[i]+now.x;
				int nj=dj[i]+now.y;
				if(ispossible(ni,nj)&&map[ni][nj]==1&&!check[ni][nj]) {
					q.add(new Point(ni,nj,now.c+1));
					check[ni][nj]=true;
				}
			}
		}
	}
	static boolean ispossible(int i,int j) {
		return i>=0&&j>=0&&i<N&&j<M;
	}
	static class Point{
		int x,y,c;
		Point(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.c=cnt;
		}
	}
}
