package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1806_부분합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int [] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		int right=0;
		int left=0;
		int length=987654321;
		int sum=0;
		while(true) {
			if(sum>=S) {
				sum-=arr[left++];
				length=Math.min((right-left+1),length);
			}
			else if(right==N) break;
			else sum+=arr[right++];
		}
		if(length==987654321)
			System.out.println(0);
		else
			System.out.println(length);
	}
}
