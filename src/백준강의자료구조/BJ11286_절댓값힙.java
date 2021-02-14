package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ11286_절댓값힙 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		PriorityQueue<Integer> pq=new PriorityQueue<>((Integer a,Integer b)->{
			int ab=Math.abs(a);
			int bb=Math.abs(b);
			if(Math.abs(a)==Math.abs(b)) {
				return a-b;
			}
			return ab-bb;
		});
		for(int i=0;i<N;i++) {
			int now=Integer.parseInt(br.readLine());
			if(now==0) {
				if(pq.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(pq.poll());
				}
				sb.append("\n");
			}else {
				pq.add(now);
			}
		}
		System.out.println(sb.toString());
	}
}
