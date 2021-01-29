package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ11437_LCA {
	static boolean []check;
	static int [] parent;
	static int [] depth;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		List<Integer> list[]=new List[N+1];
		for(int i=1;i<=N;i++)
			list[i]=new ArrayList<Integer>();
		check=new boolean[N+1];
		parent=new int[N+1];
		depth=new int[N+1];
		for(int i=1;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		LinkedList<Integer> queue=new LinkedList<>();
		check[1]=true;
		parent[1]=0;
		depth[1]=0;
		queue.add(1);
		while(!queue.isEmpty()) {
			int now=queue.poll();
			for(int next:list[now]) {
				if(check[next]==false) {
					check[next]=true;
					parent[next]=now;
					depth[next]=depth[now]+1;
					queue.add(next);
				}
			}
		}
		M=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(depth[a]<depth[b]) {
				int temp=a;
				a=b;
				b=temp;
 			}
			while(depth[a]!=depth[b]) {
				a=parent[a];
			}
			while(a!=b) {
				a=parent[a];
				b=parent[b];
			}
			sb.append(a+"\n");
		}
		System.out.println(sb.toString());
	}
}
