package 지나가다가;

import java.util.*;
import java.io.*;

public class BJ1202_보석도둑 {
	static J[] js;
	static int N, K;
	static boolean[] done;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		js = new J[N];
		done = new boolean[N];
		for (int i = 0; i < N; i++) {
			J j = new J(sc.nextInt(), sc.nextInt());
			js[i] = j;
		}
		Arrays.sort(js);
		int[] bags = new int[K];
		for (int i = 0; i < K; i++)
			bags[i] = sc.nextInt();
		Arrays.sort(bags);
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		long sum = 0;
		int j=0;
		for (int b = 0; b < K; b++) {
			int now = bags[b];
			while(j<N&&js[j].weight<=now) {
				queue.add(-js[j].value);
				j++;
			}
			if(!queue.isEmpty()) {
				sum-=queue.poll();
			}
		}
		System.out.println(sum);
	}

	static class J implements Comparable<J> {
		int weight;
		int value;

		J(int x, int y) {
			weight = x;
			value = y;
		}

		@Override
		public int compareTo(J o) {
			return this.weight - o.weight;
		}
	}
}
