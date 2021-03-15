package 프로그래머스;

public class LEVEL2_N개의최소공배수 {
	class Solution {
	    public int solution(int[] arr) {
	        int now=arr[0];
	        for(int i=1;i<arr.length;i++){
	            int next=arr[i];
	            int gdc;
	            if(next>=now){
	                gdc=getGDC(next,now);
	            }else{
	                gdc=getGDC(now,next);
	            }
	            now=(now*next)/gdc;
	        }
	        return now;
	    }
	    public int getGDC(int big,int small){
	        while(small>0){
	            int temp=big;
	            big=small;
	            small=temp%big;
	        }
	        return big;
	    }
	}
}
