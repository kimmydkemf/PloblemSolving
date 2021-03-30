package 프로그래머스LEVEL1;
import java.util.*;

public class 정수내림차순으로배치하기 {
	class Solution {
	    public long solution(long n) {
	        long answer = 0;
	        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{return b-a;});
	        while(n>0){
	            pq.add((int)(n%10));
	            n/=10;
	        }
	        while(!pq.isEmpty()){
	            answer=answer*10+pq.poll();
	        }
	        return answer;
	    }
	}
}
