package 백준강의자료DP;

import java.util.*;
import java.io.*;

public class BJ1826_연료채우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> queue=new PriorityQueue<>((Point a,Point b)->{return a.dist-b.dist;});
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			queue.add(new Point(a,b));
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int Final=Integer.parseInt(st.nextToken());
		int SF=Integer.parseInt(st.nextToken());
		int cnt=0;
		PriorityQueue<Point> queue2=new PriorityQueue<>((Point a,Point b)->{return b.fuel-a.fuel;});
		while(!queue.isEmpty()) {
			if(Final<=SF)
				break;
			Point now=queue.poll();
			if(SF>=now.dist) {
				queue2.add(now);
			}else {
				if(queue2.isEmpty())
					break;
				Point next=queue2.poll();
				SF+=next.fuel;
				cnt++;
				queue.add(now);
			}
		}
		while(!queue2.isEmpty()) {
			if(SF>=Final)
				break;
			Point next=queue2.poll();
			SF+=next.fuel;
			cnt++;
		}
		if(SF<Final)
			System.out.println(-1);
		else
			System.out.println(cnt);
	}

	static class Point{
		int fuel;
		int dist;

		Point(int d, int f) {
			fuel = f;
			dist = d;
		}


	}
}
