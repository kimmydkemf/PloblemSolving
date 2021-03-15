package 프로그래머스;

public class LEVEL2_fibo {
	class Solution {
	    int memo[];
	    public int solution(int n) {
	        int answer = 0;
	        memo=new int[100001];
	        answer = fibo(n)%1234567;
	        return answer;
	    }
	    public int fibo(int n){
	        if(n==0)
	            return 0;
	        if(n==1)
	            return memo[n]=1;
	        if(memo[n]!=0)
	            return memo[n];
	        return memo[n]=(fibo(n-1)+fibo(n-2))%1234567;
	    }
	}
}
