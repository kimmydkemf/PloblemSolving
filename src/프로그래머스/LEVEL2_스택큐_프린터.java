package 프로그래머스;

public class LEVEL2_스택큐_프린터 {
	class Solution {
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        int priority[]=new int[10];
	        boolean visit[]=new boolean[priorities.length];
	        int max=0;
	        for(int i=0;i<priorities.length;i++){
	            priority[priorities[i]]++;
	            max=Math.max(max,priorities[i]);
	        }
	        int cnt=0;
	        int idx=0;
	        while(cnt<priorities.length){
	            if(visit[idx]){
	                idx++;
	                if(idx==priorities.length)
	                    idx=0;
	                continue;
	            }
	            if(max==priorities[idx]){
	                visit[idx]=true;
	                cnt++;
	                priority[max]--;
	                if(idx==location){
	                   answer=cnt;
	                   break;
	               }
	                if(priority[max]==0){
	                    while(priority[max]==0)
	                        max--;
	                }
	            }
	            idx++;
	            if(idx==priorities.length)
	                idx=0;
	        }
	        return answer;
	    }
	}
}
