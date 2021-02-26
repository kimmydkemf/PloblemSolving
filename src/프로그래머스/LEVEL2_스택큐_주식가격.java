package 프로그래머스;

public class LEVEL2_스택큐_주식가격 {
	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        for(int i=0;i<prices.length;i++){
	               for(int j=i+1;j<prices.length;j++){
	                   if(prices[i]>prices[j]){
	                       answer[i]=j-i;
	                       break;
	                   }
	                   if(j==prices.length-1) answer[i]=prices.length-(i+1);
	               }
	        }
	        return answer;
	    }
	}
}
