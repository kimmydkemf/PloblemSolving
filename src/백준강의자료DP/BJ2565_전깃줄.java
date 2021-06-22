package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2565_전깃줄 {
	static int wire[][];
	static int dp[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		wire=new int[N][2];
		dp=new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			wire[i][0]=Integer.parseInt(st.nextToken());
			wire[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(wire, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		int max=0;
		for(int i=0;i<N;i++) {
			max=Math.max(recur(i), max);
		}
		System.out.println(N-max);
	}
	static int recur(int n) {
		if(dp[n]==0) {
			dp[n]=1;
			for(int i=n+1;i<N;i++) {
				if(wire[n][1]<wire[i][1]) {
					dp[n]=Math.max(dp[n], recur(i)+1);
				}
			}
		}
		return dp[n];
	}
}
