package 프로그래머스LEVEL1;
import java.util.*;

public class 같은숫자는싫어 {
	public class Solution {
	    public int[] solution(int []arr) {
	        int[] answer = {};
	        Queue<Integer> q=new LinkedList<>();
	        int last=-1;
	        int now;
	        for(int i=0;i<arr.length;i++){
	            now=arr[i];
	            if(last!=-1&&last!=now){
	                q.add(last);
	            }
	            last=now;
	        }
	        q.add(last);
	        answer=new int[q.size()];
	        last=0;
	        while(!q.isEmpty()){
	            answer[last++]=q.poll();
	        }
	        return answer;
	    }
	}
}
