package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ11722_가장긴감소하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		int dp[]=new int[N];
		int result=0;
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			int max=0;
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[i]&&dp[j]>max)
					max=dp[j];
			}
			dp[i]=max+1;
			if(dp[i]>result)
				result=dp[i];
		}
		System.out.println(result);
	}
}
