package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1931_회의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Meeting> pq=new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			pq.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		int cnt=0;
		int time=0;
		for(int i=0;i<N;i++) {
			Meeting temp=pq.poll();
			if(temp.start>=time) {
				cnt++;
				time=temp.end;
			}
		}
		System.out.println(cnt);
	}
	static class Meeting implements Comparable<Meeting>{
		int start,end;
		Meeting(int a,int b){
			start=a;
			end=b;
		}
		@Override
		public int compareTo(Meeting o) {
			if(end==o.end) {
				return start-o.start;
			}
			return end-o.end;
		}
	}
}
