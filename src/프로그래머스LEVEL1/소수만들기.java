package 프로그래머스LEVEL1;

public class 소수만들기 {
	class Solution {
	    public int answer;
	    public boolean[] prime;
	    public int solution(int[] nums) {
	        answer = 0;
	        prime=new boolean[3000];
	        prime[0]=true;prime[1]=true;
	        for(int i=2;i<3000;i++){
	            if(prime[i]) continue;
	            for(int j=2;j*i<3000;j++) prime[j*i]=true;
	        }
	        int length=nums.length;
	        for(int i=0;i<length;i++){
	            for(int j=i+1;j<length;j++){
	                for(int k=j+1;k<length;k++){
	                    if(!prime[nums[i]+nums[j]+nums[k]]) answer++;
	                }
	            }
	        }   
	        return answer;
	    }
	}
}
