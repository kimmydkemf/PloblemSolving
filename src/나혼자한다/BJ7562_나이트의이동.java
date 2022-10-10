package 나혼자한다;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ7562_나이트의이동 {
	static boolean map[][];
	static int di[] = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int dj[] = { 2, -2, 1, -1, 2, -2, -1, 1 };
	static Point finish;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			N = sc.nextInt();
			map = new boolean[N][N];
			int x = sc.nextInt();
			int y = sc.nextInt();
			Point now = new Point(x, y);
			finish = new Point(sc.nextInt(), sc.nextInt());
			sb.append(bfs(now) + "\n");
		}
		System.out.println(sb.toString());
	}

	static int bfs(Point now) {
		int cnt = 0;
		map[now.x][now.y] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(now);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				Point p = q.poll();
				if (finish.x == p.x && finish.y == p.y) {
					return cnt;
				}
				for (int i = 0; i < 8; i++) {
					int ni = di[i] + p.x;
					int nj = dj[i] + p.y;
					if (isIn(ni, nj) && !map[ni][nj]) {
						map[ni][nj]=true;
						q.add(new Point(ni,nj));
					}
				}
			}
			cnt++;
		}
		return 0;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
