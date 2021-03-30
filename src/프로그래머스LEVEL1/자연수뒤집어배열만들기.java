package 프로그래머스LEVEL1;
import java.util.*;

public class 자연수뒤집어배열만들기 {
	class Solution {
	    public int[] solution(long n) {
	        int[] answer = {};
	        Queue<Integer> q=new LinkedList<>();
	        while(n>0){
	            q.add((int)(n%10));
	            n/=10;
	        }
	        int len=q.size();
	        answer=new int[len];
	        for(int i=0;i<len;i++) answer[i]=q.poll(); 
	        return answer;
	    }
	}
}
