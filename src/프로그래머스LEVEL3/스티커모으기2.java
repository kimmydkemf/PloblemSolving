package 프로그래머스LEVEL3;

public class 스티커모으기2 {
	class Solution {
	    public int solution(int sticker[]) {
	        int len=sticker.length;
	        if (len <= 3) {
	            int max = 0;
	            for (int i = 0; i < len; i++) {
	                max = Math.max(max, sticker[i]);
	            }
	            return max;
	        }
	        int[] dp1 = new int[len]; // 시작 포함.
	        int[] dp2 = new int[len]; // 시작 제외.
	        dp1[0] = sticker[0];
	        dp1[1] = sticker[0];
	        dp2[0] = 0;
	        dp2[1] = sticker[1];
	        for (int i = 2; i < len-1; i++) { // 마지막 전까지 계산.
	            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]); 
	            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
	        }
	        int i = len-1;
	        dp1[i] = Math.max(dp1[i-1], dp1[i-2]); // 시작을 포함했기 때문에 마지막은 못더함.
	        dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i - 1]);
	        
	        return Math.max(dp1[i], dp2[i]);
	    }
	}

}
