package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ2252_줄세우기 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		int [] indegree=new int[N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()); int e=Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			indegree[e]++;
		}
		sb=new StringBuilder();
		topologicalsort(graph,indegree);
		System.out.println(sb.toString());
	}
	static void topologicalsort(ArrayList<ArrayList<Integer>> g,int[] in) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<in.length;i++) {
			if(in[i]==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int now=queue.poll();
			sb.append(now+" ");
			ArrayList<Integer> array=g.get(now);
			int size=array.size();
			for(int i=0;i<size;i++) {
				int down=array.get(i);
				in[down]--;
				if(in[down]==0) {
					queue.add(down);
				}
			}
		}
	}
}
