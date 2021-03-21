package 프로그래머스LEVEL1;
import java.util.*;

public class 나누어떨어지는숫자배열 {
	class Solution {
	    public int[] solution(int[] arr, int divisor) {
	        int[] answer = {};
	        int len=arr.length;
	        Queue<Integer> q=new LinkedList<>();
	        for(int i=0;i<len;i++){
	            int now=arr[i];
	            if(now%divisor==0){
	                q.add(now);
	            }
	        }
	        if(q.isEmpty()){
	            answer=new int[1];
	            answer[0]=-1;
	        }else{
	            answer=new int[q.size()];
	            int idx=0;
	            while(!q.isEmpty()){
	                answer[idx++]=q.poll();
	            }
	            Arrays.sort(answer);
	        }
	        return answer;
	    }
	}
}
