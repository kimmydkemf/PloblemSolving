package 나혼자한다;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2696_중앙값구하기 {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int M=sc.nextInt();
			PriorityQueue<Integer> min_heap=new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> max_heap=new PriorityQueue<>();
			Queue<Integer> ans=new LinkedList<>();
			int mid=sc.nextInt();
			ans.add(mid);
			for(int i=1;i<M;i++) {
				int now=sc.nextInt();
				if(now>mid) {
					max_heap.add(now);
				}else {
					min_heap.add(now);
				}
				if(i%2==0) { // 홀수번째 입력일때,
					int min_size=min_heap.size();
					int max_size=max_heap.size();
					if(min_size>max_size) {
						max_heap.add(mid);
					}else {
						min_heap.add(mid);
					}
					if(min_heap.size()>max_heap.size()) {
						mid=min_heap.poll();
					}else {
						mid=max_heap.poll();
					}
					ans.add(mid);
				}
			}
			int size=ans.size();
			sb.append(size+"\n");
			int cnt=0;
			for(int i=0;i<size;i++) {
				if(cnt==10) {
					sb.append("\n");
					cnt=0;
				}
				sb.append(ans.poll()+" ");
				cnt++;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
