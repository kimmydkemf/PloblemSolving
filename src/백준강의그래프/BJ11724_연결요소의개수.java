package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ11724_연결요소의개수 {
	static ArrayList<Integer> arr[];
	static boolean check[];
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		arr=new ArrayList[N];
		check=new boolean[N];
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0;i<N;i++) {
			arr[i]=new ArrayList<>();
			queue.add(i);
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());int b=Integer.parseInt(st.nextToken());
			arr[a-1].add(b-1);
			arr[b-1].add(a-1);
		}
		Count(queue);
	}
	static void Count(Queue<Integer> q) {
		int cnt=0;
		while(!q.isEmpty()) {
			int now=q.poll();
			if(!check[now]) {
				cnt++;
				bfs(now);
			}
		}
		System.out.println(cnt);
	}
	static void bfs(int idx) {
		Queue<Integer> queue=new LinkedList<>();
		check[idx]=true;
		queue.add(idx);
		while(!queue.isEmpty()) {
			int now=queue.poll();
			for(int i=0;i<arr[now].size();i++) {
				if(!check[arr[now].get(i)]) {
					check[arr[now].get(i)]=true;
					queue.add(arr[now].get(i));
				}
			}
		}
	}
	static class Point{
		int s,e;
		Point(int start, int end){
			s=start;
			e=end;
		}
	}
}
