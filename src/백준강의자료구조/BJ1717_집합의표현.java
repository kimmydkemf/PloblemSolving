package 백준강의자료구조;

import java.util.*;
import java.io.*;

public class BJ1717_집합의표현 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if (a == 0) {
				union(b, c);
			} else {
				int x = find(b);
				int y = find(c);
//				if(x==y)
//					sb.append("YES"+"\n");
//				else
//					sb.append("NO"+"\n");
				sb.append((x == y) ? "YES\n" : "NO\n");
			}
		}
		System.out.print(sb.toString());
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			parent[y] = x;
	}
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x]=find(parent[x]);
		}
	}
}
