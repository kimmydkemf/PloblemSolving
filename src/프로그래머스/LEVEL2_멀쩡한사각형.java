package 프로그래머스;

public class LEVEL2_멀쩡한사각형 {
	class Solution {
	    public long solution(int w, int h) {
	        int gdc;
	        if(w>=h){
	            gdc=getGDC(w,h);
	        }else
	            gdc=getGDC(h,w);
	        long answer=((long)w*h)-(w/gdc+h/gdc-1)*(long)gdc;
	        return answer;
	    }
	    int getGDC(int big,int small){
	        while(small>0){
	            int temp=big;
	            big=small;
	            small=temp%big;
	        }
	        return big;
	    }
	}
}
