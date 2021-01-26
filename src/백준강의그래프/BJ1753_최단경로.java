package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1753_최단경로 {
	static int V,E;
	static int[] dist;
	static boolean[] check;
	static LinkedList<Edge> list[];
	static int start;
	static int INF=987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		start=Integer.parseInt(br.readLine());
		
		list=new LinkedList[V+1];
		dist=new int[V+1];
		check=new boolean[V+1];
		
		for(int i=0;i<=V;i++)
			list[i]=new LinkedList<Edge>();
		
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e,c));
		}
		
		dijkstra(start);
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=V;i++) {
			sb.append(dist[i]==INF?"INF":dist[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dijkstra(int start){
		Arrays.fill(dist,INF);
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		dist[start]=0;
		queue.add(new Edge(start,0));
		while(!queue.isEmpty()) {
			Edge now=queue.poll();
			int cur=now.to;
			
			if(!check[cur]) {
				for(Edge e:list[cur]) {
					if(!check[e.to]&&dist[e.to]>dist[cur]+e.cost) {
						dist[e.to]=dist[cur]+e.cost;
						queue.add(new Edge(e.to,dist[e.to]));
					}
				}
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		Edge(int t,int c){
			to=t;
			cost=c;
		}
		public int compareTo(Edge e) {
			return cost-e.cost;
		}
	}
}
