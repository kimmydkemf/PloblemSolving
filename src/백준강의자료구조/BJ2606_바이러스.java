package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ2606_바이러스 {
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int com=Integer.parseInt(br.readLine());
		int net=Integer.parseInt(br.readLine());
		parent=new int[com+1];
		for(int i=0;i<=com;i++)
			parent[i]=i;
		for(int i=0;i<net;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			union(x,y);
		}
		int cnt=0;
		for(int i=2;i<=com;i++) {
			if(find(i)==find(1)) cnt++;
		}
		System.out.println(cnt);
	}
	static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x!=y) {
			parent[y]=x;
		}
	}
	static int find(int x) {
		if(parent[x]==x)
			return x;
		return parent[x]=find(parent[x]);
	}
}
 