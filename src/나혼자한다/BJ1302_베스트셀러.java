package 나혼자한다;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class BJ1302_베스트셀러 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Map<String,Integer> list=new HashMap<>();
		for(int i=0;i<N;i++) {
			String now=sc.next();
			int t=1;
			if(list.containsKey(now)) {
				t=list.remove(now)+1;
			}
			list.put(now, t);
		}
		Comparator<Entry<String,Integer>> comparator = new Comparator<Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()==o2.getValue()) {
					return o2.getKey().compareTo(o1.getKey());
				}
				return o1.getValue().compareTo(o2.getValue());
			}
		};
		Entry Maxvalue = Collections.max(list.entrySet(),comparator);
		System.out.println(Maxvalue.getKey());
	}
}
