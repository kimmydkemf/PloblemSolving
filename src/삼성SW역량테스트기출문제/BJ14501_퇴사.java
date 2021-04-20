package 삼성SW역량테스트기출문제;
import java.util.*;
import java.io.*;

public class BJ14501_퇴사 {
	static int N;
	static int[] arrt, arrp;
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arrt=new int[N];
		arrp=new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arrt[i]=Integer.parseInt(st.nextToken());
			arrp[i]=Integer.parseInt(st.nextToken());
		}
		max=0;
		dfs(0,0);
		System.out.println(max);
	}
	static void dfs(int idx,int sum) {
		if(idx==N) {
			max=Math.max(max,sum);
			return;
		}
		// choice
		if(idx+arrt[idx]<=N) {
			dfs(idx+arrt[idx],sum+arrp[idx]);
		}
		// not choice
		dfs(idx+1,sum);
	}
}
