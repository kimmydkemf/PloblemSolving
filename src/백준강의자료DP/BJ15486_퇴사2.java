package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ15486_퇴사2 {
	static int N,max;
	static int []dp;
	static int []t,p;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		t=new int[N+2];
		p=new int[N+2];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		max=0;
		dp=new int[N+2];
		for(int i=1;i<N+2;i++) {
			if(max<dp[i]) max=dp[i];
			
			int day=t[i]+i;
			if(day<N+2) { 
				dp[day]=Math.max(dp[day],max+p[i]);
			}
		}
		System.out.println(max);
	}
}
