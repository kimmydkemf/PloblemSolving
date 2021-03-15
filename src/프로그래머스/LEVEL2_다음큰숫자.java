package 프로그래머스;
import java.util.*;

public class LEVEL2_다음큰숫자 {
	class Solution {
	    public int solution(int n) {
	        int bitCount=Integer.bitCount(n);
	        for(int i=n+1;;i++){
	            if(bitCount==Integer.bitCount(i)){
	                return i;
	            }
	        }
	    }
	}
}
