package 프로그래머스;

public class LEVEL2_완전탐색_카펫 {
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = {};
	        int row,col=0;
	        for(row=brown/2-1;row>=col;row--){
	            col=(brown-row*2)/2+2;
	            if((col-2)*(row-2)==yellow)
	                break;
	        }
	        answer=new int[2];
	        answer[0]=row;
	        answer[1]=col;
	        return answer;
	    }
	}
}
