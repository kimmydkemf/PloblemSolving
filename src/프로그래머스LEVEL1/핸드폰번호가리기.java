package 프로그래머스LEVEL1;

public class 핸드폰번호가리기 {
	class Solution {
	    public String solution(String phone_number) {
	        String answer = "";
	        for(int i=0;i<phone_number.length()-4;i++){
	            answer+="*";
	        }
	        for(int i=phone_number.length()-4;i<phone_number.length();i++)
	            answer+=phone_number.charAt(i);
	        return answer;
	    }
	}
}
