package 프로그래머스LEVEL1;

public class 삼진법뒤집기 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        String s=to3(n);
	        int len=s.length();
	        for(int i=len-1;i>=0;i--){
	            answer+=Math.pow(3,((len-1)-i))*Integer.parseInt(s.charAt(i)+"");
	        }
	        return answer;
	    }
	    public String to3(int n){
	        String temp="";
	        while(n>0){
	            temp=temp+n%3;
	            n/=3;
	        }
	        return temp;
	    }
	}
}
