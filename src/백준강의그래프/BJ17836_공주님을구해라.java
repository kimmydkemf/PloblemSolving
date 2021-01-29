package 백준강의그래프;

import java.util.*;
import java.io.*;

public class BJ17836_공주님을구해라 {
	static int[][] map;
	static boolean[][][] visit;
	static int N, M, T;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		bfs();
	}

	static void bfs() {
		Point start = new Point(0, 0,false);
		visit[0][0][0] = true;
		LinkedList<Point> queue = new LinkedList<>();
		queue.add(start);
		int time = 0;
		while (!queue.isEmpty()) {
			if (T < time) {
				System.out.println("Fail");
				return;
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();
				if (now.x == N - 1 && now.y == M - 1) {
					System.out.println(time);
					return;
				}
				if (now.gram) {
					for (int d = 0; d < 4; d++) {
						int ni = now.x + di[d];
						int nj = now.y + dj[d];
						if (isIn(ni, nj) && visit[ni][nj][1] == false) {
							Point p = new Point(ni,nj,true);
							visit[ni][nj][1]=true;
							queue.add(p);
						}
					}
				} else {
					for (int d = 0; d < 4; d++) {
						int ni = now.x + di[d];
						int nj = now.y + dj[d];	
						if (isIn(ni, nj) && visit[ni][nj][0] == false&&map[ni][nj]!=1) {
							if(map[ni][nj]==2) {
								visit[ni][nj][1]=true;
								queue.add(new Point(ni,nj,true));
							}else {
								visit[ni][nj][0]=true;
								queue.add(new Point(ni,nj,false));
							}
						}
					}
				}
			}
			time++;
		}
		System.out.println("Fail");
		return;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class Point {
		int x;
		int y;
		boolean gram;

		Point(int x, int y,boolean gram) {
			this.x = x;
			this.y = y;
			this.gram = gram;
		}
	}
}
