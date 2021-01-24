package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1197_최소스패닝트리 {
	static int V,E;
	static int []parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken()); E=Integer.parseInt(st.nextToken());
		parent=new int[V+1];
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		for(int i=0;i<=V;i++)
			parent[i]=i;
		for(int e=1;e<=E;e++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			queue.add(new Edge(s,n,c));
		}
		int cnt=0;
		int cost=0;
		while(!queue.isEmpty()) {
			Edge now=queue.poll();
			int start=now.start;
			int end=now.end;
			if(find(start)!=find(end)) {
				union(start,end);
				cost+=now.cost;
				cnt++;
			}
			if(cnt==V-1)
				break;
		}
		System.out.println(cost);
	}
	static class Edge implements Comparable<Edge>{
		int start, end, cost;
		Edge(int s,int e,int c){
			start=s;
			end=e;
			cost=c;
		}
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	static int find(int x) {
		if(parent[x]==x)
			return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int x,int y) {
		int px=find(x);
		int py=find(y);
		if(px!=py) {
			parent[py]=px;
		}
	}
}
