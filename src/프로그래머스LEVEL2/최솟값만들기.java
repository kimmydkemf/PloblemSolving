package 프로그래머스LEVEL2;
import java.util.*;

public class 최솟값만들기 {
	class Solution
	{
	    public int solution(int []A, int []B)
	    {
	        int answer = 0;
	        int len=A.length;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        for(int i=0;i<len;i++){
	            answer+=A[i]*B[len-i-1];
	        }
	        return answer;
	    }
	}
}
