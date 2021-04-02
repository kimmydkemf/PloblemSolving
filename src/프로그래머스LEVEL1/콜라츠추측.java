package 프로그래머스LEVEL1;

public class 콜라츠추측 {
	class Solution {
	    public int solution(long num) {
	        int answer = 0;
	        int cnt=0;
	        for(cnt=0;cnt<500;cnt++){
	            if(num==1) break;
	            if(num%2==0){
	                num=num/2;
	            }else{
	                num=num*3+1;
	            }
	        }
	        return cnt==500?-1:cnt;
	    }
	}
}
