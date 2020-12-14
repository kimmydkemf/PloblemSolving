package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1707_이분그래프 {
	static int V;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			ArrayList<Integer> arr[]=new ArrayList[V];
			int check[]=new int[V];
			Queue<Point> queue=new LinkedList<>();
			for(int i=0;i<V;i++) {
				arr[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());int b=Integer.parseInt(st.nextToken());
				arr[a-1].add(b-1);
				arr[b-1].add(a-1);
				queue.add(new Point(a-1,b-1));
			}
			bfs(arr,check);
			sb.append(result(check,queue)+"\n");
		}
		System.out.println(sb.toString());
	}
	private static String result(int[] check, Queue<Point> queue) {
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			if(check[now.s]==check[now.e]) {
				return "NO";
			}
		}
		return "YES";
	}
	private static void bfs(ArrayList<Integer>[] arr, int[] check) {
		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<V;i++) {
			if(check[i]==0) {
				q.add(i);
				check[i]=1;
			}
			while(!q.isEmpty()) {
				int now=q.poll();
				for(int j=0;j<arr[now].size();j++) {
					int next=arr[now].get(j);
					if(check[next]==0) {
						if(check[now]==1) {
							check[next]=2;
							q.add(next);
						}else {
							check[next]=1;
							q.add(next);
						}
					}
				}
			}
		}
	}
	static class Point{
		int s,e;
		Point(int start,int end){
			s=start;
			e=end;
		}
	}
}
