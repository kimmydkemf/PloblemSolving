package 백준강의분할정복;

import java.util.*;
import java.io.*;

public class BJ2512_예산 {
	static int[]arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		int M = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		if (sum <= M)
			System.out.println(max);
		else {
			int first=1;
			int end=M;
			int mid = (first + end) / 2;
			int result=0;
			while (first <= end) {
				mid=(first+end)/2;
				int temp=0;
				temp = calculate(mid);
				if(temp>M){
					 end=mid-1;
				}else {
					result=mid;
					first=mid+1;
				}
			}
			System.out.println(result);
		}
	}
	static int calculate(int mid) {
		int sum=0;
		for(int i=0;i<N;i++) {
			if(arr[i]>mid) {
				sum+=mid;
			}else {
				sum+=arr[i];
			}
		}
		return sum;
	}
}
