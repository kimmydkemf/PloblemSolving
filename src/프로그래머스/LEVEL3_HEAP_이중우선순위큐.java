package 프로그래머스;
import java.util.*;

public class LEVEL3_HEAP_이중우선순위큐 {

	class Solution {
	    public int[] solution(String[] operations) {
	        int[] answer = {};
	        PriorityQueue<Integer> pq1=new PriorityQueue<>((Integer a,Integer b)->{
	            return a-b;
	        });
	        PriorityQueue<Integer> pq2=new PriorityQueue<>((Integer a,Integer b)->{
	            return b-a;
	        });
	        for(int i=0;i<operations.length;i++){
	            String temp[]=operations[i].split(" ");
	            int num=Integer.parseInt(temp[1]);
	            if(temp[0].equals("I")){
	                pq1.add(num);
	                pq2.add(num);
	            }else{
	                if(!pq1.isEmpty()){
	                    if(num>0){
	                        int n=pq2.poll();
	                        pq1.remove(n);
	                    }else{
	                        int n=pq1.poll();
	                        pq2.remove(n);
	                    }
	                }
	            }
	        }
	        answer=new int[2];
	        if(pq1.isEmpty()){
	            answer[0]=0;answer[1]=0;
	        }else{
	            answer[0]=pq2.poll();answer[1]=pq1.poll();
	        }
	        return answer;
	    }
	}
}
