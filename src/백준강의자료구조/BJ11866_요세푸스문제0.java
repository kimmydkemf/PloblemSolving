package 백준강의자료구조;
import java.util.*;

public class BJ11866_요세푸스문제0 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		Queue<Integer> q=new LinkedList<>();
		Queue<Integer> q2=new LinkedList<>();
		for(int i=1;i<=N;i++) q.add(i);
		int cnt=1;
		while(!q.isEmpty()) {
			if(cnt==M) {
				q2.add(q.poll());
				cnt=1;
			}else {
				int now=q.poll();
				cnt++;
				q.add(now);
			}
		}
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		while(q2.size()>1) sb.append(q2.poll()+", ");
		sb.append(q2.poll()+">");
		System.out.println(sb.toString());
	}
}
