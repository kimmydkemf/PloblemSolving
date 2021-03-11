package 프로그래머스;

public class LEVEL2_124나라의숫자 {
	class Solution {
	    public String solution(int n) {
	        String answer = "";;
	        while(n>0){
	            if((n-1)%3==0){
	                answer=1+answer;
	            }else if((n-1)%3==1){
	                answer=2+answer;
	            }else if((n-1)%3==2){
	                answer=4+answer;
	            }
	            n=(n-1)/3;
	        }
	        return answer;
	    }
	}
}
