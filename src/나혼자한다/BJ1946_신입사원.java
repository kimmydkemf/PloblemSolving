package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1946_신입사원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int N=Integer.parseInt(br.readLine());
			PriorityQueue<Person> pq =new PriorityQueue<>();
			for(int n=1;n<=N;n++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int	y=Integer.parseInt(st.nextToken());
				pq.add(new Person(x,y));
			}
			int cnt=0;
			int limitation=Integer.MAX_VALUE;
			while(!pq.isEmpty()) {
				Person now=pq.poll();
				if(now.second<limitation) {
					limitation=now.second;
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	static class Person implements Comparable<Person>{
		int first;
		int second;
		Person(int x,int y){
			first=x;
			second=y;
		}
		@Override
		public int compareTo(Person o) {
			return this.first-o.first;
		}
	}
}
