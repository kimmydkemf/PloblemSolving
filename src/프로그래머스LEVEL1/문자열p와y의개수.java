package 프로그래머스LEVEL1;

public class 문자열p와y의개수 {
	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        int cnt[]=new int[2];
	        String temp=s.toLowerCase();
	        for(int i=0;i<temp.length();i++){
	            if(temp.charAt(i)=='p'){
	                cnt[0]++;
	            }else if(temp.charAt(i)=='y'){
	                cnt[1]++;
	            }
	        }
	        if(cnt[0]==cnt[1])
	            return true;
	        return false;
	    }
	}
}
