package 프로그래머스;

public class LEVEL2_스택큐_다리를지나는트럭 {
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        int sumw=0;
	        int [] bridge=new int[bridge_length];
	        int idx=0;
	        int cnt=0;
	        while(cnt!=truck_weights.length){
	            answer++;
	            if(bridge[0]!=0){
	                cnt++;
	                sumw-=bridge[0];
	            }
	            for(int i=1;i<bridge_length;i++){
	                bridge[i-1]=bridge[i];
	            }
	            bridge[bridge_length-1]=0;
	            if(idx<truck_weights.length&&sumw+truck_weights[idx]<=weight){
	                sumw+=(truck_weights[idx]);
	                bridge[bridge_length-1]=truck_weights[idx++];
	            }
	        }
	        return answer;
	    }
}}
