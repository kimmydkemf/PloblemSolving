package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ2573_빙산 {
	static int map[][];
	static boolean[][] visit;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp != 0)
					queue.add(new Point(i, j));
			}
		}
		if (check()) {
			System.out.println(0);
		} else {
			int result = bfs(queue);
			System.out.println(result);
		}
	}

	private static int bfs(Queue<Point> queue) {
		int time = 0;
		while (!queue.isEmpty()) {
			time++;
			int size = queue.size();
			int[][] nmap = copymap();
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();
				for (int k = 0; k < 4; k++) {
					int nx = now.x + di[k];
					int ny = now.y + dj[k];
					if (isIn(nx, ny) && map[nx][ny] == 0) {
						nmap[now.x][now.y]--;
					}
					if (nmap[now.x][now.y] == 0)
						break;
				}
				if (nmap[now.x][now.y] != 0)
					queue.add(new Point(now.x, now.y));
			}
			map=nmap;
			if (check())
				return time;
		}
		return 0;
	}
	static int[][] copymap(){
		int[][] nmap=new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				nmap[i][j]=map[i][j];
			}
		}
		return nmap;
	}
	static boolean check() {
		visit = new boolean[R][C];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && !visit[i][j]) {
					go(i, j);
					cnt++;
				}
				if (cnt > 1) {
					return true;
				}
			}
		}
		return false;
	}

	static void go(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		visit[i][j] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int n = 0; n < 4; n++) {
				int nx = now.x + di[n];
				int ny = now.y + dj[n];
				if (isIn(nx, ny) && !visit[nx][ny] && map[nx][ny] != 0) {
					queue.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
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
