package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1948_임계경로 {
	static int[] max,in;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		max=new int[N+1];
		in=new int[N+1];
		ArrayList<Node> graph[]=new ArrayList[N+1];
		ArrayList<Node> graph2[]=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<Node>();
			graph2[i]=new ArrayList<Node>();
		}
		int edge=Integer.parseInt(br.readLine());
		for(int i=0;i<edge;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			graph[s].add(new Node(n,c));
			graph2[n].add(new Node(s,c));
			in[n]++;
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		topologicalSort(graph,Integer.parseInt(st.nextToken()));
		int end=Integer.parseInt(st.nextToken());
		int cnt=countNode(graph2,end);
		System.out.println(max[end]);
		System.out.println(cnt);
	}
	static int countNode(ArrayList<Node> graph[],int end) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(end);
		int cnt=0;
		boolean visit[]=new boolean[N+1];
		visit[end]=true;
		while(!queue.isEmpty()) {
			int now=queue.poll();
			for(Node next:graph[now]) {
				if(max[next.next]==max[now]-next.cost) {
					cnt++;
					if(!visit[next.next]) {
						queue.add(next.next);
						visit[next.next]=true;					
					}
				}
			}
		}
		return cnt;
	}
	private static void topologicalSort(ArrayList<Node> graph[],int start) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			
			int now=queue.poll();
			
			for(Node next:graph[now]) {
				
				if(max[now]+next.cost>max[next.next]) {
					max[next.next]=max[now]+next.cost;
				}
				
				in[next.next]--;
				if(in[next.next]==0) queue.add(next.next);
			}
		}
	}

	static class Node{
		int next,cost;
		Node(int n,int c){
			next=n;
			cost=c;
		}
	}
}
