package 백준강의완전탐색;

import java.util.*;
import java.io.*;

public class BJ9019_DSLR {
	static int start, end;
	static boolean[] check;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			check = new boolean[10000];
			start = sc.nextInt();
			end = sc.nextInt();
			bfs();
		}
		System.out.println(sb.toString());
	}

	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, ""));
		check[start] = true;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == end) {
				sb.append(now.s + "\n");
				return;
			}
			// D
			int next = (now.x * 2) % 10000;
			if (!check[next]) {
				queue.add(new Node(next, now.s + "D"));
				check[next] = true;
			}
			// S
			next = now.x - 1;
			if (next < 0)
				next = 9999;
			if (!check[next]) {
				queue.add(new Node(next, now.s + "S"));
				check[next] = true;
			}
			// L
			int left = now.x / 1000;
			next = now.x * 10 - left * 10000 + left;
			if (!check[next]) {
				check[next] = true;
				queue.add(new Node(next, now.s + "L"));
			}
			// R
			int right = now.x % 10;
			next = now.x / 10 + right * 1000;
			if (!check[next]) {
				check[next] = true;
				queue.add(new Node(next, now.s + "R"));
			}
		}
	}

	static class Node {
		int x;
		String s;

		Node(int x, String s) {
			this.x = x;
			this.s = s;
		}
	}
}
