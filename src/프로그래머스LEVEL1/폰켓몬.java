package 프로그래머스LEVEL1;
import java.util.*;

public class 폰켓몬 {
	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        int len=nums.length;
	        HashMap<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<len;i++){
	            map.put(nums[i],0);
	        }
	        if(map.size()<=len/2){
	            answer= map.size();
	        }else{
	            answer=len/2;
	        }
	        return answer;
	    }
	}
}
