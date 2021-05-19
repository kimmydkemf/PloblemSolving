package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1106_호텔 {
	static int C,N;
	static int dp[];
	static City arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new City[N];
		dp=new int[C+1];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i]=new City(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}		
		System.out.println(dfs(C));
	}
	static int dfs(int temp) {
		if(temp<=0) return 0;
		if(dp[temp]!=0) return dp[temp];
		int min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			min=Math.min(min, dfs(temp-arr[i].customer)+arr[i].cost);
		}
		return dp[temp]=min;
	}
	static class City{
		int cost,customer;
		City(int x,int y){
			cost=x;
			customer=y;
		}
	}
}
