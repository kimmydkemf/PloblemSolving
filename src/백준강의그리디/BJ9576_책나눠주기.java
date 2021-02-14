package 백준강의그리디;

import java.util.*;
import java.io.*;

public class BJ9576_책나눠주기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			boolean check[] = new boolean[N + 1];
			PriorityQueue<Point> pq = new PriorityQueue<>((Point a, Point b) -> {
				if (a.b == b.b)
					return a.a - b.a;
				return a.b - b.b;
			});
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pq.add(new Point(a, b));
			}
			int cnt = 0;
			while (!pq.isEmpty()) {
				Point now = pq.poll();
				for (int i = now.a; i <= now.b; i++) {
					if (check[i])
						continue;
					check[i] = true;
					cnt++;
					break;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}

	static class Point {
		int a, b;

		Point(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
