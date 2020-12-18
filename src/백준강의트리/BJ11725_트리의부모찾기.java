package 백준강의트리;
import java.util.*;
import java.io.*;

public class BJ11725_트리의부모찾기 {
	static int [] parent;
	static boolean[] visit;
	static int N;
	static ArrayList<Integer> arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		arr=new ArrayList[N+1];
		parent = new int[N+1];
		visit=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());int b=Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		bfs();
		for(int i=2;i<=N;i++)
			sb.append(parent[i]+"\n");
		System.out.println(sb.toString());
	}
	static void bfs() {
		int cnt=1;
		Queue<Integer> q=new LinkedList<>();
		q.add(1);
		visit[1]=true;
		while(!q.isEmpty()) {
			int now=q.poll();
//			System.out.print(now+"\t");
			int size=arr[now].size();
			for(int i=0;i<size;i++){
				int next=arr[now].get(i);
				if(!visit[next]) {
//				System.out.print(next+"\t");
				parent[next]=now;
				cnt++;
				q.add(next);
				visit[next]=true;
				}
				if(cnt==N)
					return;
			}
		}
	}
}
