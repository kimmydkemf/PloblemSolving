package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ13460_구슬탈출2 {
	static char[][] map;
	static int N, M;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, -1, 0, 1 };
	static boolean[][][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M][N][M];
		Queue<Point> Rqueue = new LinkedList<>();
		Queue<Point> Bqueue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char C = s.charAt(j);
				map[i][j] = C;
				if (C == 'R') {
					Rqueue.add(new Point(i, j));
					map[i][j] = '.';
				} else if (C == 'B') {
					Bqueue.add(new Point(i, j));
					map[i][j] = '.';
				}
			}
		}
		int cnt = 0;
		while (!Rqueue.isEmpty()) {
			cnt++;
			if (cnt > 10)
				break;
			int size = Rqueue.size();
			for (int i = 0; i < size; i++) {
				Point red = Rqueue.poll();
				Point blue = Bqueue.poll();
				visit[red.x][red.y][blue.x][blue.y] = true;
				for (int d = 0; d < 4; d++) {
					int rdx = red.x + di[d];
					int rdy = red.y + dj[d];
					boolean hole = false;
					int reds = 1;
					while (map[rdx][rdy] == '.') {
						rdx += di[d];
						rdy += dj[d];
						reds++;
					}
					if (map[rdx][rdy] == 'O')
						hole = true;

					int blues = 1;
					int bdx = blue.x + di[d];
					int bdy = blue.y + dj[d];

					while (map[bdx][bdy] == '.') {
						bdx += di[d];
						bdy += dj[d];
						blues++;
					}
					if (map[bdx][bdy] == 'O')
						continue;

					if (rdx == bdx && rdy == bdy) {
						if (reds > blues) {
							rdx -= di[d];
							rdy -= dj[d];
						} else {
							bdx -= di[d];
							bdy -= dj[d];
						}
					}
					if (hole) {
						System.out.println(cnt);
						System.exit(0);
					}
					if (!visit[rdx - di[d]][rdy - dj[d]][bdx - di[d]][bdy - dj[d]]) {
						visit[rdx - di[d]][rdy - dj[d]][bdx - di[d]][bdy - dj[d]] = true;
						Rqueue.add(new Point(rdx - di[d], rdy - dj[d]));
						Bqueue.add(new Point(bdx - di[d], bdy - dj[d]));
					}
				}
			}
		}
		System.out.println(-1);
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
