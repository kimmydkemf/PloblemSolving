package 프로그래머스;
import java.util.*;

public class LEVEL2_Greedy_조이스틱 {
	class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        int len=name.length();
	        int min_dist=len-1;
	        for(int i=0;i<len;i++){
	            answer+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
	            
	            int next=i+1;
	            while(next<len&&name.charAt(next)=='A')
	                next++;
	            min_dist=Math.min(min_dist,i+i+(len-next));
	            // i+i 는 현재까지 오는 i + 시작점으로 돌아가는 i
	            // 전체길이 len-현재 다음에 오는 A개수인 next를 빼줘서
	            // 더 짧은 경로를 선택!
	        }
	        answer+=min_dist;
	        return answer;
	    }
	}
}
