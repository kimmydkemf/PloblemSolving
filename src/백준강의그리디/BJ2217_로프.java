package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ2217_로프 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long result=Long.MIN_VALUE;
		for(int i=0;i<N;i++) {
			result=Math.max(result,arr[i]*(N-i));
		}
		System.out.println(result);
	}
}
