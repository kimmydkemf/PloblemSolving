package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의정렬_BJ1377_버블정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Point[] arr=new Point[N];
		for(int i=0;i<N;i++) {
			arr[i]=new Point(Integer.parseInt(br.readLine()),i);
		}
		Arrays.sort(arr);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			if(max<(arr[i].pos-i))
				max=arr[i].pos-i;
		}
		System.out.println(max+1);
	}
	static class Point implements Comparable<Point>{
		int value;
		int pos;
		Point(int v,int p){
			value=v;
			pos=p;
		}
		@Override
		public int compareTo(Point o) {
			return this.value-o.value;
		}		
	}
}
