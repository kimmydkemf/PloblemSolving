package 프로그래머스;

public class LEVEL4_선입선출스케줄링 {
	class Solution {
	    public int solution(int n, int[] cores) {
	        int answer = 0;
	        int min=cores[0];
	        int max=cores[0];
	        if(n<=cores.length) return n;
	        for(int i=0;i<cores.length;i++){
	            min=Math.min(cores[i],min);
	            max=Math.max(cores[i],max);
	        }
	        // int mint=(min*n)/cores.length-min;
	        // int maxt=(max*n)/cores.length-max;
	        
	        int mint=(min*n)/cores.length;
	        int maxt=(max*n)/cores.length;
	        
	        while(mint<=maxt){
	            int mid=(mint+maxt)/2;
	            int done=cores.length;
	            int currentwork=0;
	            for(int i:cores){
	                done+=mid/i;
	                if(mid%i==0) currentwork++;
	            }
	            if(done<n){
	                mint=mid+1;
	            }else if(done-currentwork>=n){
	                maxt=mid-1;
	            }else{
	                int cnt=0;
	                for(int i=0;i<cores.length;i++){
	                    if(mid%cores[i]==0) cnt++;
	                    if(cnt==n-(done-currentwork)) return (i+1);
	                }
	            }
	        }
	        return answer;
	    }
	   
	}
}
