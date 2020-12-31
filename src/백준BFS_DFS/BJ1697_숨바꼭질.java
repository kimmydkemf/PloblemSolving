package 백준BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697_숨바꼭질 {
	static int N,K;
	static boolean c[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); K=sc.nextInt();
		c=new boolean[100001];
		int time = bfs(N);
		System.out.println(time);
	}
	static int bfs(int start) {
		int time=0;
		Queue<Integer> queue=new LinkedList<>();
		queue.add(start);
		c[start]=true;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				int now=queue.poll();
				if(now==K)
					return time;
				int next[]=new int[3];
				next[0]=now+1;
				next[1]=now-1;
				next[2]=2*now;
				for(int j=0;j<3;j++) {
					if(next[j]>=0&&next[j]<=100000&&!c[next[j]]) {
						c[next[j]]=true;
						queue.add(next[j]);
					}
				}
			}
			time++;
		}
		return -1;
	}
}
