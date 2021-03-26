package 프로그래머스LEVEL2;

public class 쿼드압축후세기 {
	class Solution {
	    public int cnt0,cnt1;
	    public int[] solution(int[][] arr) {
	        int[] answer = new int[2];
	        cnt0=0;cnt1=0;
	        go(0,0,arr.length,arr);
	        answer[0]=cnt0;answer[1]=cnt1;
	        return answer;
	    }
	    public void go(int sx,int sy,int N,int[][] arr){
	        int start=arr[sx][sy];
	        if(N==1){
	            if(start==1) cnt1++;
	            else cnt0++;
	            return;
	        }
	        for(int i=sx;i<sx+N;i++){
	            for(int j=sy;j<sy+N;j++){
	                if(arr[i][j]!=start){
	                    go(sx,sy,N/2,arr);
	                    go(sx+N/2,sy,N/2,arr);
	                    go(sx,sy+N/2,N/2,arr);
	                    go(sx+N/2,sy+N/2,N/2,arr);
	                    return;
	                }
	            }
	        }
	        if(start==1) cnt1++;
	        else cnt0++;
	    }
	}
}
