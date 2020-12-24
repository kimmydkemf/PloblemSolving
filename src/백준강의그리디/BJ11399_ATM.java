package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ11399_ATM {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int sum=arr[0];
		for(int i=1;i<N;i++) {
			arr[i]+=arr[i-1];
			sum+=arr[i];
		}
		System.out.println(sum);
	}
}
