package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1504_특정한최단경로 {
	static int N,E;
	static int dist[];
	static boolean check[];
	static LinkedList<Line> lines[];
	static int INF=987654321;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken()); 
		E=Integer.parseInt(st.nextToken());
		
		lines=new LinkedList[N+1];
		dist=new int[N+1];
		check=new boolean[N+1];
		
		for(int i=0;i<=N;i++)
			lines[i]=new LinkedList<Line>();
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			lines[a].add(new Line(b,c));
			lines[b].add(new Line(a,c));
		}
		
		st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		
		// 1 -> A -> B -> N
		long res1=0;
		res1+=dijkstra(1,A);
		res1+=dijkstra(A,B);
		res1+=dijkstra(B,N);
		
		// 1 -> B -> A -> N
		long res2=0;
		res2+=dijkstra(1,B);
		res2+=dijkstra(B,A);
		res2+=dijkstra(A,N);
		
		long ans=(res1>=INF&&res2>=INF)? -1:Math.min(res1,res2);
		System.out.println(ans);
	}
	private static int dijkstra(int start, int end) {
		Arrays.fill(dist,INF);
		Arrays.fill(check,false);
		
		PriorityQueue<Line> queue=new PriorityQueue<>();
		dist[start]=0;
		queue.add(new Line(start,0));
		
		while(!queue.isEmpty()) {
			Line l=queue.poll();
			int cur=l.to;
			
			if(!check[cur]) {
				check[cur]=true;
				
				for(Line line:lines[cur]) {
					if(!check[line.to]&&dist[line.to]>dist[cur]+line.cost) {
						dist[line.to]=dist[cur]+line.cost;
						queue.add(new Line(line.to,dist[line.to]));
					}
				}
			}
		}
		return dist[end];
	}
	static class Line implements Comparable<Line>{
		int to;
		int cost;
		Line(int t,int c){
			to=t;
			cost=c;
		}
		@Override
		public int compareTo(Line o) {
			return this.cost-o.cost;
		}
	}
}
