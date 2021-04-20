package 삼성SW역량테스트기출문제;
import java.util.*;
import java.io.*;

public class BJ13458_시험감독 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringTokenizer st1=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st1.nextToken());
		int B=Integer.parseInt(st1.nextToken());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken())-A;
		long answer=N;
		for(int i=0;i<N;i++) {
			if(arr[i]>0) {
				answer+=arr[i]/B;
				if(arr[i]%B!=0) answer++;
			}
		}
		System.out.println(answer);
	}
}
