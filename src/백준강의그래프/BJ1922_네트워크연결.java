package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1922_네트워크연결 {
	static boolean select[];
	static int com,line;
	static List<Edge> []list;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		com=Integer.parseInt(br.readLine());
		line=Integer.parseInt(br.readLine());
		select=new boolean[com+1];
		list=new List[com+1];
		for(int i=1;i<=com;i++)
			list[i]=new ArrayList<Edge>();
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		for(int l=0;l<line;l++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[a].add(new Edge(a,b,c));
			list[b].add(new Edge(b,a,c));
		}
		int result = Prim();
		System.out.println(result);
	}
	private static int Prim() {
		select[1]=true;
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		for(int i=0;i<list[1].size();i++) {
			queue.add(list[1].get(i));
		}		
		int cost=0;
		while(!queue.isEmpty()) {
			Edge now=queue.poll();
			if(select[now.to])
				continue;
			select[now.to]=true;
			cost+=now.cost;
			for(Edge e:list[now.to])
				queue.add(e);
		}
		return cost;
	}
	static class Edge implements Comparable<Edge>{
		int from,to,cost;
		Edge(int f,int t,int c){
			from=f;
			to=t;
			cost=c;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
}
