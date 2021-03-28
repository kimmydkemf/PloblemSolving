package 프로그래머스LEVEL1;
import java.util.*;

public class 야근지수 {
	class Solution {
	    public long solution(int n, int[] works) {
	        long answer = 0;
	        PriorityQueue<Integer> pq=new PriorityQueue<>((Integer a,Integer b)->{
	            return b-a;
	        });
	        for(int i:works) pq.add(i);
	        while(n>0){
	            if(pq.isEmpty()) break;
	            int max=pq.poll();
	            max--;n--;
	            if(max!=0) pq.add(max);
	        }
	        while(!pq.isEmpty()){
	            answer+=Math.pow(pq.poll(),2);
	        }
	        return answer;
	    }
	}
}
