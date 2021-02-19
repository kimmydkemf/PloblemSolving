package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ2164_카드2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=N;i++)
			queue.add(i);
		while(queue.size()!=1) {
			queue.poll();
			if(queue.size()==1)
				break;
			int temp=queue.poll();
			queue.add(temp);
		}
		System.out.println(queue.poll());
	}
}
