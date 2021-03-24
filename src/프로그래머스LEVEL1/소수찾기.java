package 프로그래머스LEVEL1;

public class 소수찾기 {
	class Solution {
	    boolean [] prime;
	    public int solution(int n) {
	        int answer = 0;
	        prime=new boolean[1000001];
	        prime[0]=true;
	        prime[1]=true;
	        for(int i=2;i<=1000000;i++){
	            if(prime[i]) continue;
	            for(int j=2;j*i<=1000000;j++){
	                prime[j*i]=true;
	            }
	        }
	        for(int i=1;i<=n;i++){
	            if(!prime[i]) answer++;
	        }
	        return answer;
	    }
	}
}
