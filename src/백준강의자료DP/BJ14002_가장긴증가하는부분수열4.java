package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ14002_가장긴증가하는부분수열4 {
	static int dp[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		dp=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int result=0;
		for(int i=0;i<N;i++) {
			int now=Integer.parseInt(st.nextToken());
			arr[i]=now;
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
			result=Math.max(dp[i],result);
		}
		sb.append(result+"\n");
		Stack<Integer> stack=new Stack<>();
		for(int i=N-1;i>=0;i--) {
			if(dp[i]==result) {
				stack.push(arr[i]);
				result--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb.toString());
	}
}
