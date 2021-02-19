package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1976_여행가자 {
	static int parent[];
	static int route[];
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
			parent[i]=i;
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int temp=Integer.parseInt(st.nextToken());
				if(temp==1) {
					union(i,j);
				}
			}
		}
		route=new int[M];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			route[i]=Integer.parseInt(st.nextToken());
		}
		boolean result=true;
		for(int i=0;i<M-1;i++) {
			if(find(route[i])==find(route[i+1])) {
				continue;
			}
			result=false;
			break;
		}
		System.out.println(result?"YES":"NO");
	}
	static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a]=find(parent[a]);
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			if(a<b)
				parent[b]=a;
			else
				parent[a]=b;
		}
	}
}
