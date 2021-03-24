package 프로그래머스LEVEL1;

public class 문자열다루기기본 {
	class Solution {
	    public boolean solution(String s) {
	        boolean answer = true;
	        int len=s.length();
	        if(len==4||len==6){
	            if(check(s)){
	                return true;
	            }else{
	                return false;
	            }
	        }else
	            return false;
	    }
	    public boolean check(String s){
	        for(int i=0;i<s.length();i++){
	            char now=s.charAt(i);
	            if(now>='0'&&now<='9') continue;
	            return false;
	        }
	        return true;
	    }
	}
}
