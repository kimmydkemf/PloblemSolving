package 프로그래머스LEVEL1;

public class 시저암호 {
	class Solution {
	    public String solution(String s, int n) {
	        String answer = "";
	        for(int i=0;i<s.length();i++){
	            char now=s.charAt(i);
	            if(now==' '){
	                answer+=' ';
	                continue;
	            }
	            if(now>='A'&&now<='Z'){
	                if(now+n<='Z'){
	                    answer+=(char)(now+n);
	                }else{
	                    answer+=(char)(now+n-('Z'+1)+'A');
	                }
	            }else{
	                if(now+n<='z'){
	                    answer+=(char)(now+n);
	                }else{
	                    answer+=(char)(now+n-('z'+1)+'a');
	                }
	            }
	        }
	        return answer;
	    }
	}
}
