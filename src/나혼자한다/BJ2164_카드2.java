package 나혼자한다;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ2164_카드2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Deque<Integer> dq=new LinkedList<Integer>();
		for(int n=1;n<=N;n++)
			dq.add(n);
		while(true) {
			if(dq.size()==1) break;
			dq.pollFirst();
			if(dq.size()==1) break;
			int now=dq.pollFirst();
			dq.add(now);
		}
		System.out.println(dq.poll());
	}
}
