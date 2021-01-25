package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ11779_최소비용구하기2 {
	static int [] from;
	static int [] dist;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); int m=Integer.parseInt(br.readLine());
		from=new int[n+1];
		dist=new int[n+1];
		Arrays.fill(dist,987654321);
		visit=new boolean[n+1];
		LinkedList<Bus> bus[]=new LinkedList[n+1];
		for(int i=0;i<=n;i++)
			bus[i]=new LinkedList<Bus>();
		for(int i=0;i<m;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			bus[a].add(new Bus(b,c));
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int S=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		dist[S]=0;
		for(int i=0;i<n;i++) {
			int min=0;
			for(int j=1;j<=n;j++) {
				if(!visit[j]&&dist[j]<dist[min]) {
					min=j;
				}
			}
			visit[min]=true;
			for(Bus b:bus[min]) {
				if(dist[b.to]>dist[min]+b.cost) {
					dist[b.to]=dist[min]+b.cost;
					from[b.to]=min;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		sb.append(dist[E]+"\n");
		Stack<Integer> stack=new Stack<>();
		int next=E;
		stack.add(E);
		while(next!=S) {
			next=from[next];
			if(next==0)
				break;
			stack.add(next);
		}
		sb.append(stack.size()+"\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb.toString());
	}
	static class Bus{
		int to,cost;
		Bus(int t,int c){
			to=t;
			cost=c;
		}
	}
}
