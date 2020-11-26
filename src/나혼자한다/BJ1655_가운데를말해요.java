package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import 나혼자한다.MinHeap;

public class BJ1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		MinHeap min=new MinHeap();
		MaxHeap max=new MaxHeap();
		for(int i=0;i<N;i++) {
			int now=Integer.parseInt(br.readLine());
			if(min.size()==max.size()) {
				max.insert(now);
			}else {
				min.insert(now);
			}
			if(i!=0&&min.get()<max.get()) {
				int Max=max.get();
				int Min=min.get();
				max.delete();
				min.delete();
				max.insert(Min);
				min.insert(Max);
			}
			System.out.println(max.get());
		}
	}
}
