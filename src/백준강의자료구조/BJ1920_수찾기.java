package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ1920_수찾기 {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		StringBuilder sb=new StringBuilder();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int now=Integer.parseInt(st.nextToken());
			boolean result= find(now);
			if(result) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean find(int now) {
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
