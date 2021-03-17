package 프로그래머스LEVEL1;
import java.util.*;

public class 크레인인형뽑기 {
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> stack=new Stack<>();
	        for(int now:moves){
	            int pick=0;
	            for(int depth=0;depth<board.length;depth++){
	                int check=board[depth][now-1];
	                if(check!=0){
	                    pick=check;
	                    board[depth][now-1]=0;
	                    break;
	                }
	            }
	            if(pick!=0){
	                if(!stack.isEmpty()&&stack.peek()==pick){
	                    answer+=2;
	                    stack.pop();
	                }else{
	                    stack.push(pick);
	                }
	            }
	        }
	        return answer;
	    }
	}
}
