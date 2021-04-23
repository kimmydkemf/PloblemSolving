package 삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;

public class BJ19238_스타트택시 {
	static int N, M, F,count;
	static int map[][];
	static Taxi taxi;
	static Taxi person[];
	static int di[] = { 0, 0, -1, 1 };
	static int dj[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1) {
					map[i][j] = -1;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		person=new Taxi[M+1];
		taxi = new Taxi(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			map[sx - 1][sy - 1] = i + 1;
			person[i+1]=new Taxi(ex-1,ey-1);
		}
		count=0;
		while (count!=M) {
			if (simulation()) break;
			if(go()) break;
		}
		if (count!=M) {
			System.out.println(-1);
		} else {
			System.out.println(F);
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(F+"\n\n");
	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0&&map[i][j]!=-1)
					return true;
			}
		}
		return false;
	}

	static boolean go() {
		int start = map[taxi.x][taxi.y];
		int ex=person[start].x;
		int ey=person[start].y;
		int cnt = 0;
		map[taxi.x][taxi.y] = 0;
		boolean visit[][] = new boolean[N][N];
		visit[taxi.x][taxi.y] = true;
		Queue<Taxi> q = new LinkedList<>();
		q.add(taxi);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Taxi now = q.poll();
				if (now.x == ex&&now.y==ey) {
					taxi = new Taxi(now.x, now.y);
					F += cnt * 2;
					count++;
					return false;
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					if (isIn(nx, ny) && !visit[nx][ny] && map[nx][ny] != -1) {
						q.add(new Taxi(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			cnt++;
			F--;
			if (F < 0)
				return false;
		}
		return true;
	}

	static boolean simulation() {
		boolean visit[][] = new boolean[N][N];
		Taxi now = taxi;
		Queue<Taxi> q = new LinkedList<>();
		visit[now.x][now.y] = true;
		q.add(now);
		PriorityQueue<Taxi> pq = new PriorityQueue<>((Taxi a, Taxi b) -> {
			if (a.x == b.x)
				return a.y - b.y;
			return a.x - b.x;
		});
		while (!q.isEmpty()) {
			int size = q.size();
			boolean check = false;
			for (int s = 0; s < size; s++) {
				now = q.poll();
				if (map[now.x][now.y] > 0) {
					pq.add(new Taxi(now.x, now.y));
					check = true;
				}
				if (check)
					continue;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					if (isIn(nx, ny) && !visit[nx][ny] && map[nx][ny] != -1) {
						visit[nx][ny] = true;
						q.add(new Taxi(nx, ny));
					}
				}
			}
			if (check) {
				taxi = pq.poll();
				return false;
			}
			F--;
			if (F < 0)
				return true;
		}
		return true;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class Taxi {
		int x, y;

		Taxi(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

