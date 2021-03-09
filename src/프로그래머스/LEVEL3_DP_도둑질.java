package 프로그래머스;

public class LEVEL3_DP_도둑질 {
	class Solution {
	    public int solution(int[] money) {
	        int answer = 0;
	        int dp[][]=new int[money.length][2];
	        dp[0][0]=money[0];
	        dp[0][1]=0;
	        dp[1][0]=money[0];
	        dp[1][1]=money[1];
	        for(int i=2;i<money.length-1;i++){
	            dp[i][0]=Math.max(money[i]+dp[i-2][0],dp[i-1][0]);
	            dp[i][1]=Math.max(money[i]+dp[i-2][1],dp[i-1][1]);
	        }
	        int len=money.length;
	        dp[len-1][1]=Math.max(money[len-1]+dp[len-3][1],dp[len-2][1]);
	        return Math.max(dp[len-1][1],dp[len-2][0]);
	    }
	}
}
