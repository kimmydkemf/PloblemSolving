package 프로그래머스;

import java.util.*;
public class LEVEL3_HEAP_디스크컨트롤러 {

	class Solution {
	    public int solution(int[][] jobs) {
	        int answer = 0;
	        int end = 0;
	        int jobsIdx=0;
	        int cnt=0;
	        
	        Arrays.sort(jobs,(o1,o2)->{return o1[0]-o2[0];});
	        // 들어온 시간 순으로 정렬
	        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->{return o1[1]-o2[1];});
	        // 소요 시간 순으로 정렬하는 heap
	        
	        while(cnt<jobs.length){
	            
	            while(jobsIdx<jobs.length&&jobs[jobsIdx][0]<=end){
	                pq.add(jobs[jobsIdx++]);
	            }
	            // pq에 값이 없으면 현재 시간보다 늦게 job이 들어온다는 뜻!
	            if(pq.isEmpty()){
	                end=jobs[jobsIdx][0];
	            }
	            else{
	                int [] temp=pq.poll();
	                answer+=end - temp[0] +temp[1];
	                end+=temp[1];
	                cnt++;
	            }
	        }
	        return answer/jobs.length;
	    }
	    public class Job{
	        int come;
	        int length;
	        Job(int c,int l){
	            come=c;
	            length=l;
	        }
	    }
	}
}
