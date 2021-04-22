package 삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;

public class BJ16236_아기상어 {
	static int N;
	static int map[][];
	static Shark shark;
	static int time;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				if (k == 9) {
					shark = new Shark(i, j, 2,0);
					map[i][j]=0;
				}
			}
		}
		time = 0;
		while (true) {
			if (simulation())
				break;
		}
		System.out.println(time);
	}

	static boolean simulation() {
		Queue<Shark> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		int cnt = 0;
		visit[shark.x][shark.y] = true;
		queue.add(shark);
		PriorityQueue<Shark> pq=new PriorityQueue<>((Shark a,Shark b)->{
			if(a.x==b.x) return a.y-b.y;
			return a.x-b.x;
		});
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean flag=false;
			for (int s = 0; s < size; s++) {
				Shark now = queue.poll();
				if (map[now.x][now.y]!=0&&map[now.x][now.y] < now.size) {
					flag=true;
					pq.add(new Shark(now.x,now.y,now.size,now.yammy));
				}
				if(flag) continue;
				for (int i = 0; i < 4; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					if (isIn(nx, ny) && !visit[nx][ny] && map[nx][ny] <= now.size) {
						visit[nx][ny] = true;
						queue.add(new Shark(nx, ny, now.size,now.yammy));
					}
				}
			}
			if(flag) {
				Shark find=pq.poll();
				if(find.yammy+1==find.size) shark=new Shark(find.x,find.y,find.size+1,0);
				else shark=new Shark(find.x,find.y,find.size,find.yammy+1);
				map[find.x][find.y]=0;
				time+=cnt;
				return false;
			}
			cnt++;
		}
		return true;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class Shark {
		int x, y;
		int size;
		int yammy;

		Shark(int x, int y, int s,int yam) {
			this.x = x;
			this.y = y;
			this.size = s;
			this.yammy=yam;
		}
	}
}
