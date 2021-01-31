package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ20551_Sort마스터배지훈의후계자 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		HashMap<Integer,Integer> map=new HashMap<>();
		int []arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			if(map.get(arr[i])==null) {
				map.put(arr[i],i);
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			int now=sc.nextInt();
			if(map.get(now)==null) {
				sb.append(-1+"\n");
			}else {
				sb.append(map.get(now)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
