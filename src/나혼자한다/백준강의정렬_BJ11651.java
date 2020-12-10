package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의정렬_BJ11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		Point[] arr=new Point[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i]=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			sb.append(arr[i].x+" "+arr[i].y+"\n");
		}
		System.out.println(sb.toString());
	}
	static class Point implements Comparable<Point>{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Point o) {
			if(o.y==this.y)
				return this.x-o.x;
			return this.y-o.y;
		}
		
	}
}
