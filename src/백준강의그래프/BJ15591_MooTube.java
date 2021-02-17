package 백준강의그래프;

import java.util.*;
import java.io.*;

public class BJ15591_MooTube {
	static int N, Q;
	static boolean [] visit;
	static ArrayList<Node> list[];
	static class Node{
		int idx;
		int value;
		Node(int idx,int value){
			this.idx=idx;
			this.value=value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			st=new StringTokenizer(br.readLine());		
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int usa = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,usa));
			list[b].add(new Node(a,usa));
		}
		StringBuilder sb=new StringBuilder();
//		System.out.println();
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i=0;i<Q;i++) {
			st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			visit=new boolean[N+1];
			visit[v]=true;
			int cnt=bfs(v,k);
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	private static int bfs(int v, long k) {
		int sum=0;
		Queue<Integer> queue=new LinkedList<>();
		queue.add(v);
		while(!queue.isEmpty()) {
			int now=queue.poll();
			List<Node> l=list[now];
			for(int i=0;i<l.size();i++) {
				if(visit[l.get(i).idx]) {
					continue;
				}
				if(l.get(i).value<k)
					continue;
				sum++;
				queue.add(l.get(i).idx);
				visit[l.get(i).idx]=true;
			}
		}
		return sum;
	}
}
