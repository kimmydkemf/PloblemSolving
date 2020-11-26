package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1655_가운데를말해요solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		PriorityQueue<Integer> minheap=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		int first = Integer.parseInt(br.readLine());
		maxheap.add(first);
		sb.append(first+"\n");
		for(int i=1;i<N;i++) {
			int now=Integer.parseInt(br.readLine());
			if(maxheap.size()==minheap.size()) {
				maxheap.add(now);
			}else {
				minheap.add(now);
			}
			if(minheap.size()>0&&minheap.peek()<maxheap.peek()) {
				int min=minheap.poll();
				int max=maxheap.poll();
				minheap.add(max);
				maxheap.add(min);
			}
			sb.append(maxheap.peek()+"\n");
		}
		System.out.println(sb.toString());
	}
}
