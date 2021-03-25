package 프로그래머스LEVEL2;
import java.util.*;

public class 영어끝말잇기 {
	class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        int idx=1;
	        String ex=words[0];
	        HashMap<String,Integer> map=new HashMap<>();
	        map.put(ex,0);
	        for(int i=1;i<words.length;i++){
	            idx++;
	            if(idx>n)
	                idx=1;
	            if((ex.charAt(ex.length()-1)!=words[i].charAt(0))||map.containsKey(words[i])){
	                answer[0]=idx;
	                answer[1]=i/n+1;
	                break;
	            }
	            ex=words[i];
	            map.put(ex,0);
	        }
	        return answer;
	    }
	}
}
