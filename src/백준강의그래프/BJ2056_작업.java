package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ2056_작업 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		for(int i=0;i<=N;i++)
			graph.add(new ArrayList<Integer>());
		int[] in=new int[N+1];
		int[] cost=new int[N+1];
		for(int n=1;n<=N;n++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			cost[n]=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			in[n]=M;
			for(int m=0;m<M;m++) {
				int prev=Integer.parseInt(st.nextToken());
				graph.get(prev).add(n);
			}
		}
		topologicalSort(graph,in,cost);
	}

	private static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] in, int[] cost) {
		int time=0;
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<in.length;i++) {
			if(in[i]==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			time++;
			int size=queue.size();
			for(int i=0;i<size;i++) {
				int now=queue.poll();
				cost[now]--;
				if(cost[now]==0) {
					for(int next:graph.get(now)) {
						in[next]--;
						if(in[next]==0) {
							queue.add(next);
						}
					}
				}else {
					queue.add(now);
				}
			}
		}
		System.out.println(time);
	}
}
