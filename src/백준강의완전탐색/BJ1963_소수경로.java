package 백준강의완전탐색;

import java.util.*;
import java.io.*;

public class BJ1963_소수경로 {
	static int start, end;
	static boolean[] check;
	static LinkedList<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		queue = new LinkedList<>();
		check = new boolean[10000];
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < 10000; i++) {
			if (check[i])
				continue;
			int j = 2;
			while (i * j < 10000) {
				check[i * j] = true;
				j++;
			}
		}
		for (int i = 1000; i < 10000; i++) {
			if (!check[i]) {
				queue.add(i);
			}
		}
		for (int tc = 1; tc <= TC; tc++) {
			start = sc.nextInt();
			end = sc.nextInt();
			check = new boolean[10000];
			int result = bfs(start, end);
			sb.append((result == -1 ? "Impossible" : result) + "\n");
		}
		System.out.println(sb.toString());
	}

	static int bfs(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		int cnt = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				int now = q.poll();
				if (now == e) {
					return cnt;
				}
				int size = queue.size();
				for (int j = 0; j < size; j++) {
					int next = queue.poll();
					if (possible(next, now) && !check[next]) {
						check[next] = true;
						q.add(next);
					}
					queue.add(next);
				}
			}
			cnt++;
		}
		return -1;
	}

	static boolean possible(int next, int now) {
		boolean poss = false;
		while (now > 0) {
			if (next % 10 != now % 10) {
				if (poss) {
					return false;
				}
				poss = true;
			}
			next /= 10;
			now /= 10;
		}
		return true;
	}
}
