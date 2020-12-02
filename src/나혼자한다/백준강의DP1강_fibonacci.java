package 나혼자한다;

public class 백준강의DP1강_fibonacci {
	static int memo[];
	public static void main(String[] args) {
		int N=10;
		memo=new int[N+1];
		int result = fibo(N);
		System.out.println(result);
	}
	static int fibo(int n) {
		if(n<=1) {
			memo[n]=n;
			return n;
		}
		else {
			if(memo[n]>0)
				return memo[n];
			memo[n]=fibo(n-1)+fibo(n-2);
			return memo[n];
		}
	}
}
