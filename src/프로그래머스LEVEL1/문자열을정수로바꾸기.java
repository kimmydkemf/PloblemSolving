package 프로그래머스LEVEL1;

public class 문자열을정수로바꾸기 {
	class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        if(s.charAt(0)=='-'){
	            answer=-(Integer.parseInt(s.substring(1)));
	        }else{
	            if(s.charAt(0)=='+')
	                answer=Integer.parseInt(s.substring(1));
	            else
	                answer=Integer.parseInt(s.substring(0));
	        }
	        return answer;
	    }
	}
}
