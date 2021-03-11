package 프로그래머스;

public class LEVEL3_2n타일링 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        int []dp=new int[n+1];
	        dp[0]=0;
	        dp[1]=1;
	        dp[2]=2;
	        dp[3]=3;
	        for(int i=3;i<=n;i++)
	            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
	        return dp[n]%1000000007;
	    }
	}
}
