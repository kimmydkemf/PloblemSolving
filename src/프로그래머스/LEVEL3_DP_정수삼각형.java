package 프로그래머스;

public class LEVEL3_DP_정수삼각형 {
	class Solution {
	    public int solution(int[][] triangle) {
	        long answer = 0;
	        int len=triangle.length;
	        long dp[][]=new long[len+1][len+1];
	        for(int i=1;i<=len;i++){
	            for(int j=1;j<=i;j++){
	                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i-1][j-1];
	            }
	        }
	        for(int i=0;i<=len;i++)
	            answer=Math.max(dp[len][i],answer);
	        return (int)answer;
	    }
	}
}
