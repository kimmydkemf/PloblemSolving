package 프로그래머스LEVEL3;

public class 기지국설치 {
	class Solution {
	    public int solution(int n, int[] stations, int w) {
	        int answer=0;
	        int station=1;
	        int len=stations.length;
	        for(int i=0;i<len;i++){
	            int temp=stations[i]-w-station;
	            if(temp>0){
	                answer+=(temp)/(2*w+1);
	                if((temp)%(2*w+1)>0) answer++;
	            }
	            station=stations[i]+w+1;
	        }
	        if(n-station+1>0){
	            answer+=(n-station+1)/(2*w+1);
	            if((n-station+1)%(2*w+1)>0) answer++;
	        }
	        return answer;
	    }
	}
}
