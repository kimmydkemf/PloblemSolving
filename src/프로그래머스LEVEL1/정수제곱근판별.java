package 프로그래머스LEVEL1;

public class 정수제곱근판별 {
	class Solution {
	    public long solution(long n) {
	        long answer = 0;
	        long temp=(long)Math.sqrt(n);
	        if(Math.pow(temp,2)==n){
	            answer = (long)Math.pow(temp+1,2);
	        }else answer=-1;
	        return answer;
	    }
	}
}
