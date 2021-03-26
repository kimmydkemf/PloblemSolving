package 프로그래머스LEVEL1;

public class 수박수박수박수 {
	class Solution {
	    public String solution(int n) {
	        String answer = "";
	        for(int i=0;i<n;i++){
	            if(i%2==0){
	                answer+="수";
	            }else
	                answer+="박";
	        }
	        return answer;
	    }
	}
}
