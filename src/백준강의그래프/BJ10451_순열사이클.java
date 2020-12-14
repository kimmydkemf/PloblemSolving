package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ10451_순열사이클 {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			int N=Integer.parseInt(br.readLine());
			arr=new int[N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				arr[i]=Integer.parseInt(st.nextToken())-1;
			boolean visit[]=new boolean[N];
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(!visit[i]) {
					cnt++;
					dfs(i,visit);
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int i, boolean[] visit) {
		visit[i]=true;
		int next=arr[i];
		if(!visit[next]) {
			dfs(next,visit);
		}
	}
}
