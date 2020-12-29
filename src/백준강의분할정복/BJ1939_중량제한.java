package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ1939_중량제한 {
	static int N,M;
	static ArrayList<Point>[] arr;
	static long maxlimit;
	static boolean []visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
		arr=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			arr[i]=new ArrayList<Point>();
		}
		long max=0;
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			int j=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			long limit=Long.parseLong(st.nextToken());
			arr[j].add(new Point(k,limit));
			arr[k].add(new Point(j,limit));
			if(limit>max)
				max=limit;
		}
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken()); int end=Integer.parseInt(st.nextToken());
		maxlimit=0;
		long l=0;
		long r=max;
		while(l<=r) {
			long mid=(r+l)/2;
			visit=new boolean[N+1];
			if(cango(start,end,mid)) {
				if(mid>maxlimit)
					maxlimit=mid;
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		System.out.println(maxlimit);
	}
	static boolean cango(int start,int end,long mid) {
		if(visit[start])
			return false;
		visit[start]=true;
		if(start==end)
			return true;
		int size=arr[start].size();
		for(int i=0;i<size;i++) {
			Point now=(Point)arr[start].get(i);
			if(now.limit >=mid) {
				if(cango(now.x,end,mid))
					return true;
			}
		}
		return false;
	}
	static class Point implements Comparable<Point>{
		int x;
		long limit;
		Point(int x,long limit){
			this.x=x;
			this.limit=limit;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return (int)(this.limit-o.limit);
		}
	}
}
