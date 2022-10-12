package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10816_숫자카드2 {
	static int N,M;
	static int []arr1,arr2;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		arr1=new int[N];
		for(int i=0;i<N;i++) arr1[i]=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(br.readLine());
		arr2=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) arr2[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr1);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			sb.append(find(i)+" ");
		}
		System.out.println(sb.toString());
	}
	static int find(int number) {
		int now=arr2[number];
		// 끝나는 위치 찾기.
		int l=0;
		int r=N;
		int finish=0;
		int mid=0;
		while(l<=r) {
			mid=(l+r)/2;
			if(mid==N) break;
			if(arr1[mid]<=now) {
				finish=mid;
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		l=0;
		r=N;
		finish+=1;
		int start=-1;
		mid=0;
		// 시작 위치 찾기.
		while(l<=r) {
			mid=(l+r)/2;
			if(mid==N) break;
			if(arr1[mid]<now) {
				l=mid+1;
			}else {
				if(arr1[mid]==now) start=mid;
				r=mid-1;
			}
		}
		if(start==-1) start=finish;
		return finish-start;
	}
}
