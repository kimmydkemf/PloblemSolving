package 프로그래머스;
import java.util.*;

public class LEVEL1_탐욕법_체육복 {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        boolean no[]=new boolean[n+1];
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        for(int i=0;i<lost.length;i++)
	            no[lost[i]]=true;
	        for(int i=0;i<reserve.length;i++){
	            if(no[reserve[i]]==true){
	                no[reserve[i]]=false;
	                reserve[i]=0;   
	            }
	        }
	        for(int i=0;i<reserve.length;i++){
	            if(reserve[i]==0)
	                continue;
	           if(no[reserve[i]-1]==true){
	               no[reserve[i]-1]=false; 
	            }else if(reserve[i]+1<=n&&no[reserve[i]+1]==true){
	                no[reserve[i]+1]=false;
	            }
	        }
	        int answer1=n;
	        for(int i=1;i<=n;i++)
	            if(no[i]==true) answer1--;
	  
	        
	        return answer1;
	    }
	}
}
