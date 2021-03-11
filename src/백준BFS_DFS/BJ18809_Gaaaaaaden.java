package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ18809_Gaaaaaaden {
	static int di[] = { 0, 0, 1, -1 };
	static int dj[] = { -1, 1, 0, 0 };
	static int map[][], origin[][];
	static boolean visit[][];
	static int flower;
	static int N, M, G, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		// 0 호수 1 배양x 2 배양o
		ArrayList<Point> pos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] == 2) {
					pos.add(new Point(i, j));
				}
			}
		}
		int comb[] = new int[pos.size()];
		flower = 0;
		permu(comb, pos, 0, 0, 0);
		System.out.println(flower);
	}

	static void copymap() {
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (origin[i][j] == 0)
					map[i][j] = -1;
			}
		}
	}

	static void permu(int[] comb, ArrayList<Point> pos, int cntR, int cntG, int idx) {
		if (cntR > R || cntG > G)
			return;
		if (cntR + cntG == G + R) {
			copymap();
			simulation(comb, pos);
			return;
		}
		if(idx>=pos.size())
			return;
		comb[idx] = 1;
		permu(comb, pos, cntR + 1, cntG, idx + 1);
		comb[idx] = 2;
		permu(comb, pos, cntR, cntG + 1, idx + 1);
		comb[idx] = 0;
		permu(comb, pos, cntR, cntG, idx + 1);
	}

	private static void simulation(int[] comb, ArrayList<Point> pos) {
		int result = 0;
		Queue<Point> Green = new LinkedList<>();
		Queue<Point> Red = new LinkedList<>();
		boolean visitr[][]=new boolean[N][M];
		boolean visitg[][]=new boolean[N][M];
		for (int i = 0; i < comb.length; i++) {
			if (comb[i] == 1) {
				Point R = pos.get(i);
				map[R.x][R.y] = 1;
				visitr[R.x][R.y]=true;
				Red.add(R);
			} else if (comb[i] == 2) {
				Point B = pos.get(i);
				map[B.x][B.y] = 2;
				Green.add(B);
				visitg[B.x][B.y]=true;
			}
		}
		while (!Green.isEmpty() || !Red.isEmpty()) {
			Queue<Point> nextg = new LinkedList<>();
			Queue<Point> nextr = new LinkedList<>();
			int size = Green.size();
			for (int i = 0; i < size; i++) {
				Point now = Green.poll();
				if (map[now.x][now.y] == 3) {
					result++;
					continue;
				}
				for (int k = 0; k < 4; k++) {
					int nx = di[k] + now.x;
					int ny = dj[k] + now.y;
					if (isIn(nx, ny) && map[nx][ny] == 0&&!visitg[nx][ny]) {
						nextg.add(new Point(nx, ny));
						visitg[nx][ny]=true;
					}
				}
			}
			size = Red.size();
			for (int i = 0; i < size; i++) {
				Point now = Red.poll();
				if(map[now.x][now.y]==3)
					continue;
				for (int k = 0; k < 4; k++) {
					int nx = di[k] + now.x;
					int ny = dj[k] + now.y;
					if (isIn(nx, ny) && map[nx][ny] == 0&&!visitr[nx][ny]) {
						nextr.add(new Point(nx, ny));
						visitr[nx][ny]=true;
					}
				}
			}
			while (!nextg.isEmpty()) {
				Point next = nextg.poll();
				map[next.x][next.y] += 2;
				Green.add(next);
			}
			while (!nextr.isEmpty()) {
				Point next = nextr.poll();
				map[next.x][next.y] += 1;
				Red.add(next);
			}
		}
//		if(result==7)
//			print();
//		System.out.println();
		flower = Math.max(flower, result);
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
