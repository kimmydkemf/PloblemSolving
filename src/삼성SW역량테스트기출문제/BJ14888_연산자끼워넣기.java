package 삼성SW역량테스트기출문제;
import java.util.*;
import java.io.*;

public class BJ14888_연산자끼워넣기 {
	static int arr[];
	static int N,max,min;
	static int value[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		value=new int[4];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) value[i]=Integer.parseInt(st.nextToken());
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		dfs(arr[0],1);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int sum,int idx) {
		if(idx==N) {
			max=Math.max(max,sum);
			min=Math.min(min,sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(value[i]==0) continue;
			value[i]--;
			switch(i) {
			case 0:
				dfs(sum+arr[idx],idx+1);
				break;
			case 1:
				dfs(sum-arr[idx],idx+1);
				break;
			case 2:
				dfs(sum*arr[idx],idx+1);
				break;
			case 3:
				dfs(sum/arr[idx],idx+1);
				break;
			}
			value[i]++;
		}
	}
}
