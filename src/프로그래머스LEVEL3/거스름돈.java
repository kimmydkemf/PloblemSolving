package 프로그래머스LEVEL3;
import java.util.*;

public class 거스름돈 {
	class Solution {
	    int mod=1000000007;
	    public int solution(int n, int[] money) {
	        int answer = 0;
	        int dp[][]=new int[money.length+1][n+1];
	        Arrays.sort(money);
	        dp[0][0]=1;
	        for(int i=1;i<=money.length;i++){
	            int now=money[i-1];
	            for(int j=0;j<=n;j++){
	               if(j<now)
	                   dp[i][j]=dp[i-1][j]%mod;
	                else if(j==now)
	                    dp[i][j]=(dp[i-1][j]+1)%mod;
	                else
	                    dp[i][j]=(dp[i-1][j]+dp[i][j-now])%mod;
	            }
	        }
	        return dp[money.length][n]%mod;
	    }
	}
}
