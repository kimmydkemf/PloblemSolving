package 프로그래머스;

public class LEVEL2_숫자의표현 {
	class Solution {
	    public int solution(int n) {
	        int answer = 1;
	        for(int i=1;i<n;i++){
	            int sum=i;
	            for(int j=i+1;j<n;j++){
	                sum+=j;
	                if(sum>n)
	                    break;
	                if(sum==n){
	                    answer++;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	}
}
