package 나혼자한다;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ3079_입국심사 {
	static long[]arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long M=sc.nextLong();
		arr=new long[N];
		for(int n=0;n<N;n++) {
			arr[n]=sc.nextLong();
		}
		System.out.println(binarySearch(N,M));
	}
	private static long binarySearch(int n, long m) {
		long result=Long.MAX_VALUE;
		long max=Long.MAX_VALUE;
		long min=0;
		while(max>=min) {
			long mid=(max+min)/2;
			long sum=0;
			for(long t:arr) {
				long need=mid/t;
				if(sum>=m) break;
				sum+=need;
			}
			if(sum>=m) {
				result=Math.min(result, mid);
				max=mid-1;
			}else {
				min=mid+1;
			}
		}
		return result;
	}
}
