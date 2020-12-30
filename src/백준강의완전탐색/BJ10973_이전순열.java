package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ10973_이전순열 {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		if(prePermutation()) {
			StringBuilder sb=new StringBuilder();
			for(int a:arr) {
				sb.append(a+" ");
		
			}
			System.out.println(sb.toString());
		}else {
			System.out.println(-1);
		}
	}
	static boolean prePermutation() {
		int i=arr.length-1;
		while(i>0&&arr[i]>arr[i-1]) i--;
		if(i<=0)
			return false;
		int j=i;
		for(int t=i;t<arr.length;t++) {
			if(arr[t]>arr[j]&&arr[i-1]>arr[t])
				j=t;
		}
		int temp=arr[i-1];
		arr[i-1]=arr[j];
		arr[j]=temp;
		j=arr.length-1;
		while(i<=j) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		return true;
	}
}
