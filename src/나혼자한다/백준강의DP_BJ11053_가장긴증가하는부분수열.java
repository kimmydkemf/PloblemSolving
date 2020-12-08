package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int dp[]=new int[N];
		int arr[]=new int[N];
		int result=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			int max=0;
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]&&dp[j]>max) {
					max=dp[j];
				}
			}
			dp[i]=max+1;
			if(result<dp[i])
				result=dp[i];
		}
		System.out.println(result);
	}
}
