package SW아카데미;

import java.util.*;
import java.io.*;

public class SW4615_재밌는오셀로 {
	static int map[][];
	static int di[] = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int dj[] = { 1, -1, 0, -1, 1, 0, 1, -1 };
	static int N, K;
	static int white, black;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map=new int[N][N];
			map[N/2-1][N/2-1]=2;
			map[N/2][N/2-1]=1;
			map[N/2-1][N/2]=1;
			map[N/2][N/2]=2;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int color = Integer.parseInt(st.nextToken());
				simulation(x, y, color);
//				print();
			}
			white = 0;
			black = 0;
			count();
			sb.append("#"+tc+" "+black+" "+white+"\n");
		}
		System.out.println(sb.toString());
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static void count() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					black++;
				else if (map[i][j] == 2)
					white++;
			}
		}
	}

	static void simulation(int x, int y, int color) {
		map[x][y] = color;
		for (int i = 0; i < 8; i++) {
			int nx = di[i] + x;
			int ny = dj[i] + y;
			if (!isIn(nx, ny) || map[nx][ny] == 0 || map[nx][ny] == color)
				continue;
			while (isIn(nx, ny) && map[nx][ny] != 0 && map[nx][ny] != color) {
				nx += di[i];
				ny += dj[i];
			}
			if (!isIn(nx, ny) || map[nx][ny] == 0)
				continue;
			nx = di[i] + x;
			ny = dj[i] + y;
			while (isIn(nx, ny) && map[nx][ny] != 0 && map[nx][ny] != color) {
				map[nx][ny] = color;
				nx += di[i];
				ny += dj[i];
			}
		}
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
