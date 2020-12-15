package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ9466_텀프로젝트_시간초과 {
	static int[]arr;
	static int[]check;
	static boolean[]finished;
	static int num;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int TC=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=TC;tc++) {
			int N = Integer.parseInt((br.readLine()));
			st=new StringTokenizer(br.readLine());
			arr=new int[N+1];
			num=N;
			check=new int[N+1];
			finished=new boolean[N+1];
			for(int i=1;i<=N;i++)
				arr[i]=Integer.parseInt(st.nextToken());
			for(int i=1;i<=N;i++) {
				if(!finished[i]) {
					dfs(i,i);
				}
			}
			sb.append(num+"\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int i,int start) {
		if(arr[i]==i) {
			finished[i]=true;
//			System.out.print("arr[i]==i: "+i+"\t");
			num--;
			return;
		}
		if(check[i]==start) {
//			System.out.print("check[i]==start"+i+"\t");
			num--;
			finished[i]=true;
			if(!finished[arr[i]])
				dfs(arr[i],start);
		}
		check[i]=start;
		if(!finished[arr[i]])
			dfs(arr[i],start);
	}
}
