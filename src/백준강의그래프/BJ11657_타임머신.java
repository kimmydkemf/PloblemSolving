package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ11657_타임머신 {
	static int N,M;
	static long[] length;
    static int INF = 987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken()); 
		M=Integer.parseInt(st.nextToken());
		
		Edge list[]=new Edge[M];
		
		length=new long[N+1];
		
		for(int i=1;i<=N;i++) {
			length[i]=INF;
		}
		
		length[1]=0;
		for(int m=0;m<M;m++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[m]=new Edge(a,b,c);
		}
		boolean result = Bellman(list);
		
		if(result) {
			System.out.println(-1);			
		}else {
			for(int i=2;i<=N;i++) {
				if(length[i]==INF)
					System.out.println("-1");
				else
					System.out.println(length[i]);
			}
		}
	}
	private static boolean Bellman(Edge[] list) {
		for(int i=1;i<N;i++) {
			for(int j=0;j<M;j++) {
				int x=list[j].from;
				int y=list[j].to;
				int z=list[j].cost;
				if(length[x]==INF)
					continue;
				if(length[y]>length[x]+z) {
					length[y]=length[x]+z;
				}
			}
		}
		for(int j=0;j<M;j++) {
			int x=list[j].from;
			int y=list[j].to;
			int z=list[j].cost;
			if(length[x]!=INF&&length[y]>length[x]+z) {
				return true;
			}
		}
		return false;
	}
	static class Edge{
		int from,to,cost;
		Edge(int f,int t, int c){
			from=f;
			to=t;
			cost=c;
		}
	}
}
