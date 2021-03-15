package 프로그래머스;

public class LEVEL2_최댓값과최솟값 {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        String[] temp=s.split(" ");
	        int max=Integer.MIN_VALUE;
	        int min=Integer.MAX_VALUE;
	        for(String ts:temp){
	            int t=Integer.parseInt(ts);
	            min=Math.min(t,min);
	            max=Math.max(max,t);
	        }
	        answer+=min+" "+max;
	        return answer;
	    }
	}
}
