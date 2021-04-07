package 프로그래머스LEVEL1;

public class x만큼간격이있는n개의숫자 {
	class Solution {
	    public long[] solution(int x, int n) {
	        long[] answer=new long[n];
	        long temp=0;
	        for(int i=0;i<n;i++){
	                temp+=x;
	                answer[i]=temp;
	            }
	        return answer;
	    }
	}
}
