package 프로그래머스LEVEL3;
import java.util.*;

public class 숫자게임 {
	class Solution {
	    public int solution(int[] A, int[] B) {
	        int answer = 0;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        int idx=B.length-1;
	        for(int i=A.length-1;i>=0;i--){
	            if(A[i]<B[idx]){
	                idx--;
	                answer++;
	            }
	        }
	        return answer;
	    }
	}
}
