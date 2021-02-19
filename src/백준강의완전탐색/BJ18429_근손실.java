package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ18429_근손실 {
	static int N,M;
	static int []arr;
	static boolean []visit;
	static int comb;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		visit=new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		comb=0;
		combi(0,500);
		System.out.println(comb);
	}
	private static void combi(int idx, int sum) {
		if(sum<500)
			return;
		if(idx==N) {
			comb++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				combi(idx+1,sum+arr[i]-M);
				visit[i]=false;
			}
		}
	}
}
