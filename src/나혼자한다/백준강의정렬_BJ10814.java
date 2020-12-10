package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의정렬_BJ10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		Point [] arr=new Point[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i]=new Point(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			sb.append(arr[i].x+" "+arr[i].str+"\n");
		}
		System.out.println(sb.toString());
	}
	static class Point implements Comparable<Point>{
		int x;
		String str;
		Point(int x,String str){
			this.x=x;
			this.str=str;
		}
		@Override
		public int compareTo(Point o) {
			return this.x-o.x;
		}
	}
}
