package 백준강의그래프;

import java.util.*;
import java.io.*;

public class BJ1260_DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			arr[B].add(A);
		}
		for(int i=1;i<=N;i++)
			Collections.sort(arr[i]);
		int check[] = new int[N + 1];
		dfs(arr, V, check, sb);
		init(check);
		sb.append("\n");
		bfs(arr, V, check, sb);
		System.out.println(sb.toString());
	}

	private static void bfs(ArrayList<Integer>[] arr, int idx, int[] check, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<>();
		check[idx] = 1;
		queue.add(idx);
		while (!queue.isEmpty()) {
			int now=queue.poll();
			sb.append(now + " ");
			for (int i = 0; i < arr[now].size(); i++) {
				int next=arr[now].get(i);
				if (check[next] == 0) {
					check[next]=1;
					queue.add(next);
				}					
			}
		}
	}

	private static void dfs(ArrayList<Integer>[] arr, int idx, int[] check, StringBuilder sb) {
		check[idx] = 1;
		sb.append(idx + " ");
		for (int i = 0; i < arr[idx].size(); i++) {
			if (check[arr[idx].get(i)] == 0)
				dfs(arr, arr[idx].get(i), check, sb);
		}
	}

	private static void init(int[] check) {
		int length = check.length;
		for (int i = 0; i < length; i++) {
			check[i] = 0;
		}
	}
}
