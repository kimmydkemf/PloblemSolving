package 프로그래머스LEVEL1;

public class 최대공약수와최소공배수 {
	class Solution {
	    public int[] solution(int n, int m) {
	        int[] answer = {};
	        answer=new int[2];
	        if(n>=m){
	            answer[0]=getGDC(n,m);    
	        }else{
	            answer[0]=getGDC(m,n);
	        }
	        answer[1]=(n*m)/answer[0];
	        return answer;
	    }
	    public int getGDC(int big,int small){
	        while(small>0){
	            int temp=big;
	            big=small;
	            small=temp%small;
	        }
	        return big;
	    }
	}
}
