package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ10655_마라톤1 {
	static int N;
	static Point[] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new Point[N];
		long total=0;
		arr[0]=new Point(sc.nextInt(),sc.nextInt());
		for(int i=1;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[i]=new Point(a,b);
			total+=Math.abs(arr[i-1].x-a)+Math.abs(arr[i-1].y-b);
		}	
		int skip=0;
		for(int i=1;i<N-1;i++) {
			Point pre=arr[i-1];
			Point now=arr[i];
			Point next=arr[i+1];
			int d=dist(pre,now)+dist(now,next);
			int st=dist(pre,next);
			skip=Math.max(skip,d-st);
		}
		System.out.println(total-skip);
	}
	static int dist(Point a,Point b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
