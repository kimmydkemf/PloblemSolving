package 프로그래머스;
import java.util.*;

public class LEVEL4_이분탐색_징검다리 {
	class Solution {
	    public int solution(int distance, int[] rocks, int n) {
	        int answer = 0;
	        int start=1;
	        int end=distance;
	        Arrays.sort(rocks);
	        while(start<=end){
	            int mid=(start+end)/2;
	            if(check(mid,distance,rocks,n)){
	                answer=Math.max(answer,mid);
	                start=mid+1;
	            }else{
	                end=mid-1;
	            }
	        }
	        return answer;
	    }
	    public boolean check(int mid,int dist,int[] rocks,int n){
	        int start=0;
	        int cnt=0;
	        for(int i=0;i<rocks.length;i++){
	            if(rocks[i]-start<mid){
	                cnt++;
	            }else start=rocks[i];
	        }
	        if(dist-start<mid) cnt++;
	        if(cnt<=n) return true;
	        else return false;
	    }
	}
}
