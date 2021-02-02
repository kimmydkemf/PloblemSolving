package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1715_카드정렬하기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			queue.add(sc.nextInt());
		}
		long sum=0;
		while(!queue.isEmpty()) {
			int n1=queue.poll();
			if(queue.isEmpty())
				break;
			int n2=queue.poll();
			sum+=(n1+n2);
			queue.add(n1+n2);
		}
		System.out.println(sum);
	}
}
