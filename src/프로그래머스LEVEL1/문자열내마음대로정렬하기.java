package 프로그래머스LEVEL1;
import java.util.*;

public class 문자열내마음대로정렬하기 {
	class Solution {
	    public String[] solution(String[] strings, int n) {
	        String[] answer = {};
	        Arrays.sort(strings,(a,b)->{
	            if(a.charAt(n)==b.charAt(n)){
	                return a.compareTo(b);
	            }else
	               return a.charAt(n)-b.charAt(n);});
	        return strings;
	    }
	}
}
