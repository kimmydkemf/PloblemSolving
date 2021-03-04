package 프로그래머스;

public class LEVEL2_Greedy_큰수만들기 {
	class Solution {
	    long max=0;
	    public String solution(String number, int k) {
	        StringBuilder sb=new StringBuilder();
	        int length=number.length();
	        int cnt=number.length()-k; // 선택갯수.
	        int idx=0;
	        int right=k;
	        int left=0;
	        int max=-1;
	        while(cnt>0){
	            max=-1;
	            for(int i=left;i<=right;i++){
	                int now=number.charAt(i)-'0';
	                if(now>max){
	                    idx=i;
	                    max=now;
	                }
	            }
	            sb.append(max);
	            left=idx+1;
	            right=number.length()- --cnt;
	        }
	        return sb.toString();
	    }
	   
	}
}
