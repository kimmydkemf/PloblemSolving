package 나혼자한다;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11286_절대값힙 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		PriorityQueue<ABS> pq=new PriorityQueue<>();
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<N;i++) {
			int now=sc.nextInt();
			if(now==0) {
				if(pq.size()==0) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll().origin+"\n");
				}
			}else pq.add(new ABS(now,Math.abs(now)));
		}
		System.out.println(sb.toString());
	}
	static class ABS implements Comparable<ABS>{
		int origin;
		int abs;
		ABS(int a,int b){
			origin=a;
			abs=b;
		}
		@Override
		public int compareTo(ABS o) {
			if(abs==o.abs) {
				return origin-o.origin;
			}
			return abs-o.abs;
		}
	}
}
