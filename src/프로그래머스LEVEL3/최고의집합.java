package 프로그래머스LEVEL3;
import java.util.*;

public class 최고의집합 {
	class Solution {
	    public int[] solution(int n, int s) {
	        int[] answer;
	        if(s<n){
	            answer=new int[1];
	            answer[0]=-1;
	        }else{
	            int cnt=s%n;
	            int ave=s/n;
	            answer=new int[n];
	            for(int i=n-1;i>=0;i--){
	                answer[i]=ave+(cnt>0?1:0);
	                cnt--;
	            }
	        }
	        return answer;
	    }
	}
}
