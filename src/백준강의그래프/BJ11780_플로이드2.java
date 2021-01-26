package 백준강의그래프;

import java.util.*;
import java.io.*;

public class BJ11780_플로이드2 {
	static int V, E;
	static int[][] map;
	static int[][] path;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		map = new int[V + 1][V + 1];
		path = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				path[i][j] = INF;
				if (i == j)
					continue;
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (map[start][end] < cost)
				continue;
			map[start][end] = cost;
			path[start][end] = start;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (i == j || map[i][k] == INF || map[k][j] == INF)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				sb.append((map[i][j] == INF ? 0 : map[i][j]) + " ");
			}
			sb.append("\n");
		}
//		for(int i=1;i<=V;i++) {
//			for(int j=1;j<=V;j++) {
//				System.out.print(from[i][j]+" ");
//			}
//			System.out.println();
//		}
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (path[i][j] == INF) {
					sb.append("0\n");
				} else {
					Stack<Integer> stack = new Stack<>();
					int start=j;
					stack.push(j);
					while(i!=path[i][start]) {
						start=path[i][start];
						stack.push(start);
					}
					sb.append(stack.size()+1 + " ");
					sb.append(i+" ");
					while (!stack.isEmpty()) {
						sb.append(stack.pop() + " ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

	static class Edge {
		int to;
		int cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
