package 프로그래머스LEVEL1;
import java.util.*;

public class 문자열내림차순으로배치하기 {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        char[] temp=s.toCharArray();
	        Arrays.sort(temp);
	        for(int i=s.length()-1;i>=0;i--){
	            answer+=temp[i];
	        }
	        return answer;
	    }
	}
}
