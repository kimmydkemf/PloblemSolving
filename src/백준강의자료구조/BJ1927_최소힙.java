package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ1927_최소힙 {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			int n=sc.nextInt();
			if(n==0) {
				if(queue.isEmpty())
					sb.append("0\n");
				else
					sb.append(queue.poll()+"\n");
			}else {
				queue.add(n);
			}
		}
		System.out.println(sb.toString());
	}
}