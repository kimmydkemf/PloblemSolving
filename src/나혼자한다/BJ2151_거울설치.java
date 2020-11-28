package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ2151_거울설치 {
	static int N;
	static char[][] map;
	static boolean[][][] visit;
	static Queue<Point> q;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[] d1 = {3,2,1,0};
    static int[] d2 = {2,3,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N][4];
		q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char now = line.charAt(j);
				map[i][j] = now;
				if (now == '#' && q.isEmpty()) {
					map[i][j]='.';
					for (int k = 0; k < 4; k++)
						q.add(new Point(i, j, k, 0));
				}
			}
		}
		bfs();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Point now = q.poll();
			int x = now.x;
			int y = now.y;
			int d = now.dir;
			int cnt = now.cnt;
			
			if (visit[x][y][d])
				continue;
			
			visit[x][y][d] = true;
			
			if (map[x][y] == '#') {
				System.out.println(cnt);
				return;
			}

			int nx=x+di[d];
			int ny=y+dj[d];
			
			if(nx<0||nx>=N||ny<0||ny>=N||map[nx][ny]=='*')
				continue;
			if (map[nx][ny] == '!') { // 거울위치다. 3방향 가능.
					q.add(new Point(nx,ny,d1[d],cnt+1));
					q.add(new Point(nx, ny, d2[d], cnt+1));
				}
			q.add(new Point(nx, ny, d, cnt));
		}
	}

	// 생성자를 보는 단축키는 cmd+alt+s
	static class Point implements Comparable<Point>{
		int x, y;
		int dir;
		int cnt;

		public Point(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}
		
	}
}
