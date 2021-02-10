package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ16918_봄버맨 {
	static char map[][];
	static int R, C;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'O')
					queue.add(new Point(i, j));
			}
		}
		if (S % 2 == 0) {
			madeMap();
			print();
		} else {
			S /= 2;
			for (int k = 0; k < S; k++) {
				madeMap();
				while (!queue.isEmpty()) {
					Point now = queue.poll();
					map[now.x][now.y]='.';
					for (int i = 0; i < 4; i++) {
						int nx = now.x + di[i];
						int ny = now.y + dj[i];
						if (isIn(nx, ny)) {
							map[nx][ny]='.';
						}
					}
				}
				for(int a=0;a<R;a++) {
					for(int b=0;b<C;b++){
						if(map[a][b]=='O')
							queue.add(new Point(a,b));
					}
				}
			}
			print();
		}
	}
	static void madeMap() {
		for(int a=0;a<R;a++) {
			for(int b=0;b<C;b++){
				map[a][b]='O';
			}
		}
	}
	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
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
