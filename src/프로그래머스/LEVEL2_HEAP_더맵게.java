package 프로그래머스;
import java.util.*;

public class LEVEL2_HEAP_더맵게 {

	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> pq=new PriorityQueue<>((Integer a,Integer b)->{
	            return a-b;
	        });        
	        int cnt=0;
	        for(int i=0;i<scoville.length;i++){
	            pq.add(scoville[i]);
	        }
	        while(!pq.isEmpty()){
	            int n1=pq.poll();
	            if(n1>=K){
	                pq.add(n1);
	                break;
	            }
	            if(pq.isEmpty())
	                break;
	            cnt++;
	            int n2=pq.poll();
	            int mix=n1+n2*2;
	            pq.add(mix);
	        }
	        if(pq.isEmpty())
	            cnt=-1;
	        return cnt;
	    }
	}
}
