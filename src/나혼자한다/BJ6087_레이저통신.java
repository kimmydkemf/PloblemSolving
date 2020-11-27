package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ6087_레이저통신 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, -1, 0, 1 };
	static char[][] map;
	static int[][] visit;
	static int W, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visit = new int[H][W];
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			String line = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = line.charAt(j);
				visit[i][j]=Integer.MAX_VALUE;
				if (queue.isEmpty() && map[i][j] == 'C') {
					map[i][j] = '.';
					queue.add(new Point(i, j, -1, 0));
				}
			}
		}
		System.out.println(simulation(queue));
	}

	private static int simulation(Queue<Point> queue) {
		// bfs를 할때 보내고 확인을 먼저하고 보내면서 visit 처리를 해주는 방식을 사용하여야 한다.
		int mirror = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (map[now.x][now.y] == 'C') {
				mirror = now.mirror;
			}					
			for (int i = 0; i < 4; i++) {
				int nx = now.x + di[i];
				int ny = now.y + dj[i];
				if (nx < 0 || nx >= H || ny < 0 || ny >= W||map[nx][ny] == '*') {
					continue;
				}
				int mir=now.mirror;
				if (now.dir == i||now.dir==-1); 
				else
					mir++;
				if(visit[nx][ny]<mir)
					continue;
				queue.add(new Point(nx, ny, i, mir));
				visit[nx][ny]=mir;
			}
		}
		return mirror;
	}

	static class Point {
		int x, y;
		int dir;
		int mirror;

		Point(int x, int y, int dir, int mirror) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mirror = mirror;
		}
	}
}
