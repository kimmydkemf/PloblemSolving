package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ17142_연구소3 {
	static int N, M;
	static ArrayList<Virus> arr;
	static Virus select[];
	static int map[][];
	static boolean visit[][];
	static int cnt = Integer.MAX_VALUE;
	static int zero = 0,vi=0;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					continue;
				if (map[i][j] == 2) {
					arr.add(new Virus(i, j));
					vi++;
				}
				zero++;
			}
		}
		select = new Virus[M];
		comb(0, 0, M, select);
		System.out.println(cnt==Integer.MAX_VALUE?-1:cnt);
	}

	static int simulation(Virus[] select) {
		Queue<Virus> q = new LinkedList<>();
		visit = new boolean[N][N];
		for (int i = 0; i < select.length; i++) {
			Virus now = select[i];
			visit[now.x][now.y] = true;
			q.add(now);
//			System.out.println(i+"번쨰:" +now.x+" "+now.y+" ");
		}
		int count = 0;
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if(count+vi==zero) break;
			for (int s = 0; s < size; s++) {
				Virus now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					if (isIn(nx, ny) && !visit[nx][ny] && map[nx][ny] != 1) {
						q.add(new Virus(nx, ny));
						visit[nx][ny] = true;
						if(map[nx][ny]==0) count++;
					}
				}
			}
			time++;
		}
//		System.out.println(time);
//		System.out.println();
		if(count==zero-vi)
			return time;
		return -1;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static void comb(int idx, int count, int m, Virus[] select) {
		if (arr.size() - idx + count < M)
			return;
		if (count == m) {
			int temp= simulation(select);
			if(temp!=-1) {
				cnt=Math.min(cnt,temp);
			}
			return;
		}
		select[count] = arr.get(idx);
		comb(idx + 1, count + 1, m, select);
		comb(idx + 1, count, m, select);
	}

	static class Virus {
		int x, y;

		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
