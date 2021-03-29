package 프로그래머스LEVEL3;
import java.util.*;

public class 줄서는방법 {
	class Solution {
	    public  int[] solution(int n, long k) {
	        ArrayList<Integer> al = new ArrayList<>();
	        int[] result = new int[n];
	        long fn = 1;
	        for(int i = 1;  i <= n; i++) {
	            fn *= i;
	            al.add(i);
	        }
	        k--; // 순열은 0부터 시작이므로 -1해줌.
	    
	        // 1. dp[i] = n! n-1! n-2!
	        int idx = 0;
	        while(n>0) {
	            fn /= n;            //n번 째 자리수가 정해짐
	            result[idx++] =  al.remove((int)(k/fn));
	            k %= fn;
	            n--;
	        }
	        return result;
	    }
	}
}
