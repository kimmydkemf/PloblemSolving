package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1182_부분수열의합 {
	static int[] arr;
	static int cnt,N,S;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); S=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		cnt=0;
		if(S==0)
			cnt--;
		comb(0,0,new int[N]);
		System.out.println(cnt);
	}
	static void comb(int idx,int ct,int[] now) {
		if(idx==N) {
			int sum=0;
			for(int i=0;i<N;i++)
				sum+=now[i];
			if(sum==S) {
				cnt++;
			}
			return;
		}
		comb(idx+1,ct,now);
		now[ct]=arr[idx];
		comb(idx+1,ct+1,now);
		now[ct]=0;
	}
}
