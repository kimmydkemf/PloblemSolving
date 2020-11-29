package 나혼자한다;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2606_바이러스 {
	static int cnt=0;
	static boolean[][]map;
	static boolean[]virus;
	static int Com;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Com=sc.nextInt();
		int line=sc.nextInt();
		map=new boolean[Com+1][Com+1];
		virus=new boolean[Com+1];
		for(int i=0;i<line;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			map[start][end]=true;
			map[end][start]=true;
		}
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);
		virus[1]=true;
		bfs(q);
		System.out.println(cnt);
	}
	private static void bfs(Queue<Integer> q) {
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int i=1;i<=Com;i++) {
				if(map[now][i]&&!virus[i]) {
					virus[i]=true;
					q.add(i);
					cnt++;
				}
			}
		}
	}
}
