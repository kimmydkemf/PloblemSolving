package 프로그래머스LEVEL1;

public class 제일작은수제거하기 {
	class Solution {
	    public int[] solution(int[] arr) {
	        int[] answer = {};
	        int len=arr.length;
	        if(len-1==0){
	            answer=new int[1];
	            answer[0]=-1;
	        }else{
	            answer=new int[len-1];
	            int min=0;
	            for(int i=1;i<len;i++){
	                if(arr[min]>arr[i]) min=i;
	            }
	            int t=0;
	            for(int i=0;i<len;i++){
	                if(i==min) continue;
	                answer[t++]=arr[i];
	            }
	        }
	        return answer;
	    }
	}
}
