package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ2331_반복수열 {
	static int max;
	static int[]arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		arr=new int[1000000];
		max=1;
		arr[N]=1;
		dfs(N,P);		
		System.out.println(max);
	}
	static void dfs(int N,int P) {
		int result=0;
		for(int i=N;i>0;i/=10) {
			result+=Math.pow(i%10,P);
		}
		if(arr[result]==0) {
			arr[result]++;
			max++;
			dfs(result,P);
		}else if(arr[result]==1) {
			arr[result]++;
			max--;
			dfs(result,P);
		}
	}
}
