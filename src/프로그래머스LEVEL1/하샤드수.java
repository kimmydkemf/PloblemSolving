package 프로그래머스LEVEL1;

public class 하샤드수 {
	class Solution {
	    public boolean solution(int x) {
	        boolean answer = true;
	        int temp=0;
	        int xt=x;
	        while(xt>0){
	            temp+=xt%10;
	            xt/=10;
	        }
	        return x%temp==0?answer:false;
	    }
	}
}
