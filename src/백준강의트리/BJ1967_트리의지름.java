package 백준강의트리;
import java.util.*;
import java.io.*;

public class BJ1967_트리의지름 {
	static int V;
	static ArrayList<Edge> arr[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		arr=new ArrayList[V+1];
		for(int i=1;i<=V;i++)
			arr[i]=new ArrayList<>();
		for(int i=0;i<V-1;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			int cost=sc.nextInt();
			arr[start].add(new Edge(end,cost));
			arr[end].add(new Edge(start,cost));
		}
		int[] dist=bfs(1);
		int nextstart=find(dist);
		dist=bfs(nextstart);
		Arrays.sort(dist);
		System.out.println(dist[V]);
	}
	static int find(int[] dist) {
		int next=1;
		for(int i=2;i<=V;i++) {
			if(dist[next]<dist[i])
				next=i;
		}
		return next;
	}
	static int[] bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		boolean visit[]=new boolean[V+1];
		int[] dist=new int[V+1];
		q.add(start);
		visit[start]=true;
		while(!q.isEmpty()) {
			int now=q.poll();
			for(Edge e:arr[now]) {
				int next=e.num;
				int cost=e.cost;
				if(!visit[next]) {
					visit[next]=true;
					dist[next]=dist[now]+cost;
					q.add(next);
				}
			}
		}
		return dist;
	}
	static class Edge{
		int num;
		int cost;
		Edge(int n,int c){
			num=n;
			cost=c;
		}
	}
}
