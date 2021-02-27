package 프로그래머스;
import java.util.*;

public class LEVEL2_스택큐_기능개발 {

	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        boolean finish[]=new boolean[progresses.length];
	        Queue<Progress> queue=new LinkedList<>();
	        Queue<Integer> queue2=new LinkedList<>();
	        for(int i=0;i<progresses.length;i++)
	            queue.add(new Progress(progresses[i],i));
	        while(!queue.isEmpty()){
	            int size=queue.size();
	            int cnt=0;
	            for(int i=0;i<size;i++){
	                Progress now=queue.poll();
	                now.pro=Math.min(now.pro+speeds[now.idx],100);
	                if(now.pro==100&&(now.idx==0||finish[now.idx-1])){
	                    finish[now.idx]=true;
	                    cnt++;
	                }else{
	                    queue.add(new Progress(now.pro,now.idx));
	                }
	            }
	            if(cnt>0)
	                queue2.add(cnt);
	        }
	        int [] answer=new int[queue2.size()];
	        int idx=0;
	        while(!queue2.isEmpty()){
	            answer[idx++]=queue2.poll();
	        }
	        return answer;
	    }
	    public class Progress{
	        int pro;
	        int idx;
	        Progress(int p,int i){
	            pro=p;
	            idx=i;
	        }
	    }
	}
}
