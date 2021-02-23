package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ18500_미네랄2 {
	static int R, C;
	static char map[][];
	static int visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int cnt,check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = R - 1; i >= 0; i--) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		int com = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < com; i++) {
			int go = Integer.parseInt(st.nextToken());
			int j = 0;
			if (i % 2 == 0) {
				while (j < C) {
					if (map[go - 1][j] != 'x') {
						j++;
					} else {
						map[go - 1][j] = '.';
						break;
					}
				}
			} else {
				j = C - 1;
				while (j >= 0) {
					if (map[go - 1][j] != 'x') {
						j--;
					} else {
						map[go - 1][j] = '.';
						break;
					}
				}
			}
			simulation();
		}
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void simulation() {
		cnt = 0;
		PriorityQueue<Point> queue = new PriorityQueue<>((Point a, Point b) -> {
			if (a.x == b.x)
				return a.y - b.y;
			return a.x - b.x;
		});
		visit = new int[R][C];
		check=0;
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x' && visit[i][j] == 0) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		if (cnt == 1&&check==0)
			return;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == check)
					queue.add(new Point(i, j));
			}
		}
		PriorityQueue<Point> queue2 = new PriorityQueue<>((Point a, Point b) -> {
			if (a.x == b.x)
				return a.y - b.y;
			return a.x - b.x;
		});
		while (true) {
			while (!queue.isEmpty()) {
				Point now = queue.poll();
				if (now.x == 0 || (visit[now.x - 1][now.y] > 0)&&visit[now.x-1][now.y]!=check) {
					return;
				}
				queue2.add(now);
			}
			while (!queue2.isEmpty()) {
				Point now = queue2.poll();
				map[now.x][now.y] = '.';
				map[now.x - 1][now.y] = 'x';
				queue.add(new Point(now.x-1,now.y));
			}
		}
	}

	static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		visit[i][j] = cnt;
		queue.add(new Point(i, j));
		boolean c=false;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if(now.x==0)
				c=true;
			for (int d = 0; d < 4; d++) {
				int nx = now.x + di[d];
				int ny = now.y + dj[d];
				if (isIn(nx, ny) && visit[nx][ny] == 0 && map[nx][ny] == 'x') {
					visit[nx][ny] = cnt;
					queue.add(new Point(nx, ny));
				}
			}
		}
		if(!c)
			check=cnt;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
