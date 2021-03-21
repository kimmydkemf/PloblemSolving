package 프로그래머스LEVEL1;

public class 가운데글자가져오기 {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        int len=s.length();
	        if(len%2==1){
	            answer+=s.charAt(len/2);   
	        }else{
	            answer+=s.charAt(len/2-1)+""+s.charAt(len/2);
	        }
	        return answer;
	    }
	}
}
