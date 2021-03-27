package 프로그래머스LEVEL3;

public class 풍선터뜨리기 {
	class Solution {
	    public int solution(int[] a) {
	        int answer = 0;
	        int l=1000000000;
	        int r=1000000000;
	        for(int i=0;i<a.length;i++){
	            if(a[i]<l){
	                answer++;
	                l=a[i];
	            }
	            if(a[a.length-1-i]<r){
	                answer++;
	                r=a[a.length-1-i];
	            }
	            if(r==l) break;
	        }
	        return answer+(r==l?-1:0);
	    }
	}
}
