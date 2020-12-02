package 나혼자한다;

public class 백준강의DP2강_fibonacci2 {
	public static void main(String[] args) {
		int N=10;
		int [] dp=new int[N+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
