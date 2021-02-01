package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ10815_숫자카드 {
	static long []arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new long[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		Arrays.sort(arr);
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			long now=Long.parseLong(st.nextToken());
			boolean result=find(now);
			sb.append((result?1:0)+" ");			
		}
		System.out.println(sb.toString());
	}
	private static boolean find(long now) {
		int end=arr.length-1;
		int start=0;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==now) {
				return true;
			}
			if(arr[mid]>now) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return false;
	}
}
