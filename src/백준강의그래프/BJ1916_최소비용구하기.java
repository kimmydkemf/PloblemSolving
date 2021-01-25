package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1916_최소비용구하기 {
	static boolean check[];
	static long [] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		dist=new long[N+1];
		Arrays.fill(dist,987654321);
		check=new boolean[N+1];
		LinkedList<Edge> list[]=new LinkedList[N+1];
		for(int i=0;i<=N;i++)
			list[i]=new LinkedList<Edge>();
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,c));
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int S=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		dist[S]=0;
		for(int i=0;i<N;i++) {			
			int min=0;
			for(int j=1;j<=N;j++) {
				if(!check[j]&&dist[j]<dist[min]) {
					min=j;
				}
			}
			check[min]=true;
			for(Edge e:list[min]) {
				if(dist[e.e]>dist[min]+e.c) {
					dist[e.e]=dist[min]+e.c;
				}
			}
		}
		System.out.println(dist[E]);
	}
	static class Edge{
		int e,c;
		Edge(int e,int c){
			this.e=e;
			this.c=c;
		}
	}
}
