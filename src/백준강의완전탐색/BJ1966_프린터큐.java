package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int arr[]=new int[N];
			boolean visit[]=new boolean[N];
			int findpos=Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq=new PriorityQueue<>((Integer a,Integer b)->{return b-a;}) ;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int now=Integer.parseInt(st.nextToken());
				arr[i]=now;
				pq.add(now);
			}
			int cnt=0;
			int pos=0;
			while(true) {
				int del=pq.poll();
				while(true) {
					if(pos==N)
						pos=0;
					if(arr[pos]==del&&!visit[pos]) {
						break;
					}
					pos++;
				}
				cnt++;
				visit[pos]=true;
				if(pos==findpos)
					break;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
}
