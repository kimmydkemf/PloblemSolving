package 프로그래머스LEVEL2;

import java.util.*;

public class 게임맵최단거리 {
	class Solution {
		boolean[][] visit;
		int n, m;
		int[] di = { 0, 0, -1, 1 };
		int[] dj = { -1, 1, 0, 0 };

		public int solution(int[][] maps) {
			int answer = 0;
			n = maps.length;
			m = maps[0].length;
			visit = new boolean[maps.length][maps[0].length];
			answer = bfs(0, 0, maps);
			return answer;
		}

		public int bfs(int x, int y, int[][] map) {
			Queue<Point> queue = new LinkedList<Point>();
			visit[x][y] = true;
			queue.add(new Point(x, y));
			int length = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				length++;
				for (int k = 0; k < size; k++) {
					Point now = queue.poll();
					if (now.x == n - 1 && now.y == m - 1) {
						return length;
					}
					for (int i = 0; i < 4; i++) {
						int nx = di[i] + now.x;
						int ny = dj[i] + now.y;
						if (isIn(nx, ny) && map[nx][ny] == 1 && !visit[nx][ny]) {
							visit[nx][ny] = true;
							queue.add(new Point(nx, ny));
						}
					}

				}
			}
			return -1;
		}

		public boolean isIn(int x, int y) {
			return x >= 0 && y >= 0 && x < n && y < m;
		}

		public class Point {
			int x, y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}
}
