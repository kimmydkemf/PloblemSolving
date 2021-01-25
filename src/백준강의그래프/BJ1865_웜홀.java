package 백준강의그래프;

import java.util.*;
import java.io.*;

public class BJ1865_웜홀 {
	static int INF = 500 * 10_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int[] city = new int[N + 1];

			Edge[] line = new Edge[2 * M + W];

			int index = 0;

			for (int i = 0; i < M + W; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				// 무방향이기 때문에 반대방향도 추가한다.
				if (i < M) {
					line[index++] = new Edge(start, end, cost);
					line[index++] = new Edge(end, start, cost);
					// 웜홀은 유방향이기 때문에 시간만 * -1 해주어서 추가한다.
				} else {
					line[index++] = new Edge(start, end, cost * -1);
				}
			}

			boolean check = false;
			Arrays.fill(city, INF);
			city[1] = 0;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < line.length; j++) {
					Edge road = line[j];

					if (city[road.start] + road.cost < city[road.end]) {
						city[road.end] = city[road.start] + road.cost;
					}
				}
			}
			for (int i = 0; i < line.length; i++) {
				Edge road = line[i];
				if (city[road.start] + road.cost < city[road.end]) {
					check = true;
					break;
				}
			}

			if (check) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}

	static class Edge {
		int start;
		int end;
		int cost;

		Edge(int s, int e, int c) {
			start = s;
			end = e;
			cost = c;
		}
	}
}
