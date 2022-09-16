package 나혼자한다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11866_요세푸스문제0 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=N;i++)
			q.add(i);
		int start=0;
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		while(q.size()>1) {
			start++;
			if(start==K) {
				sb.append(q.poll()+", ");
				start=0;
				continue;
			}
			q.add(q.poll());
		}
		sb.append(q.poll()+">");
		System.out.println(sb.toString());
	}
	public static void print(Queue<Integer> q) {
		Queue<Integer> q2=new LinkedList<>();
		for(int i=0;i<q.size();i++) {
			System.out.print(q.poll());
		}
		System.out.println();
	}
}
