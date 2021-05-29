package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1263_시간관리{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Task> pq=new PriorityQueue<>((Task a,Task b)->{
			return b.endt-a.endt;
		});
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			pq.add(new Task(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Task now=pq.poll();
		int start=now.endt-now.take;
		while(!pq.isEmpty()) {
			now=pq.poll();
			if(start<now.endt) {
				start-=now.take;
			}else {
				start=now.endt-now.take;
			}
		}
		if(start<0) System.out.println(-1);
		else System.out.println(start);
	}
	static class Task{
		int take;
		int endt;
		Task(int t,int e){
			take=t;
			endt=e;
		}
	}
}
