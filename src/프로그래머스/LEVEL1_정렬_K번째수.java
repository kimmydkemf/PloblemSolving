package 프로그래머스;
import java.util.*;

public class LEVEL1_정렬_K번째수 {
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int size=commands.length;
	        int[] answer = new int[size];
	        int idx=0;
	        for(int [] com:commands){
	            int length=com[1]-com[0]+1;
	            int[] temp=new int[length];
	            for(int i=com[0]-1;i<com[1];i++){
	                temp[i-(com[0]-1)]=array[i];
	            }
	            Arrays.sort(temp);
	            answer[idx++]=temp[com[2]-1];
	        }
	        return answer;
	    }
	}
}
