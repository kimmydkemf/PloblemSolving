package 프로그래머스;
import java.util.*;

public class LEVEL3_Greedy_단속카메라 {
	class Solution {
	    public int solution(int[][] routes) {
	        int answer = 0;
	        PriorityQueue<Point> pq=new PriorityQueue<>((Point a,Point b)->{
	            return b.s-a.s;
	        });
	        int pos=30001;
	        for(int i=0;i<routes.length;i++){
	            pq.add(new Point(routes[i][0],routes[i][1]));
	        }
	        int cnt=0;
	        while(!pq.isEmpty()){
	            Point now=pq.poll();
	            if(pos==30001){
	                pos=now.s;
	                cnt++;
	            }else{
	                if(pos<=now.e){
	                    continue;
	                }else{
	                    pos=now.s;
	                    cnt++;
	                }
	            }
	        }
	        return cnt;
	    }
	    public class Point{
	        int s;
	        int e;
	        Point(int start,int end){
	            s=start;
	            e=end;
	        }
	    }
	}
}
