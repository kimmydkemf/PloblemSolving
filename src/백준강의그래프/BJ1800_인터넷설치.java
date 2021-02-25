package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1800_인터넷설치 {
	static int N,P,K;
	static ArrayList<Node> list[];
	static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		dist=new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Node>();
		}
		int max=0;
		for(int i=0;i<P;i++) {
			st=new StringTokenizer(br.readLine());
			
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end,value));
			list[end].add(new Node(start,value));
			
			max=Math.max(max,value);
		}
		int start=0;
		int answer=Integer.MAX_VALUE;
		
		while(start<=max) {
			int mid=(start+max)/2;
			if(dijkstra(mid)) {
				answer=mid;
				max=mid-1;
			}else {
				start=mid+1;
			}
		}
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	private static boolean dijkstra(int mid) {
		PriorityQueue<Node> pq=new PriorityQueue<>((Node a,Node b)->{
			return a.value-b.value;
		});
		for(int i=1;i<=N;i++)
			dist[i]=Integer.MAX_VALUE;
		dist[1]=0;
		pq.add(new Node(1,0));
		while(!pq.isEmpty()) {
			Node node =pq.poll();
			
			int now=node.idx;
			int cost=node.value;
			
			if(dist[now]<cost)
				continue;
			for(Node n:list[now]) {
				int next=n.idx;
				int nextcost=cost;
				
				if(n.value>mid)
					nextcost+=1;
				if(nextcost<dist[next]) {
					dist[next]=nextcost;
					pq.add(new Node(next,nextcost));
				}
			}
		}
		return dist[N]<=K;
	}
	static class Node{
		int value;
		int idx;
		Node(int i,int v){
			value=v;
			idx=i;
		}
	}
}
