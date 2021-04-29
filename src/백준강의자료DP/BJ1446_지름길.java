package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1446_지름길 {
	static int N,D;
	static int dp[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		dp=new int[D+1];
		for(int i=0;i<=D;i++) dp[i]=i;
		PriorityQueue<Point> pq=new PriorityQueue<>((Point a,Point b)->{
			return a.end-b.end;
		});
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(e>D) continue;
			if(e-s<=c) continue;
			pq.add(new Point(s,e,c));
		}
		while(!pq.isEmpty()) {
//			print();
			Point now=pq.poll();
			int temp=dp[now.end];
			dp[now.end]=Math.min(dp[now.start]+now.cost,dp[now.end]);
			if(temp==dp[now.end]) continue;
			for(int i=now.end+1;i<=D;i++) {
				dp[i]=Math.min(dp[i],dp[i-1]+1);
			}
		}
		System.out.println(dp[D]);
	}
	static void print() {
		for(int i=0;i<=D;i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
	}
	static class Point{
		int start,end,cost;
		Point(int s,int e,int c){
			start=s;
			end=e;
			cost=c;
		}
	}
}
