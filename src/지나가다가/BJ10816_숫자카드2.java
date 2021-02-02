package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ10816_숫자카드2 {
	static long []arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		arr=new long[N];
		for(int i=0;i<N;i++)
			arr[i]=Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		int M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			long now=Long.parseLong(st.nextToken());
			sb.append(find(now)+" ");
		}
		System.out.println(sb.toString());
	}
	private static int find(long now) {
		int high=high(now);
		int low=low(now);		
		return high-low+1;
	}
	private static int low(long now) {
		int start=0;
		int end=N;
		while(start<end) {
			int mid=(start+end)>>1;
			if(arr[mid]==now) {
				end=mid;
			}
			else if(arr[mid]>now) {
				end=mid;
			}else {
				start=mid+1;
			}
		}
		return start+1;
	}
	private static int high(long now) {
		int start=0;
		int end=N;
		while(start<end) {
			int mid=(start+end)>>1;
			if(arr[mid]==now) {
				start=mid+1;
			}
			else if(arr[mid]>now) {
				end=mid;
			}else {
				start=mid+1;
			}
		}
		return end;
	}
}
