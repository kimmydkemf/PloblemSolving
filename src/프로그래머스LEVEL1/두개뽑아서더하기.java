package 프로그래머스LEVEL1;
import java.util.*;
/*
 * hashmap을 사용해서 중복을 처리하고.
 * hash에서 key 값을 빼낼때는 (자료형) key:hashmap.keySet() 형태로 순차로 빼낼수 있음.
 * EntrySet을 이용해서 loop하는 방법과 Iterator를 이용하는 방법또한 존재.
 * sort를 통해서 오름차순으로 재정리해줌.
 */
public class 두개뽑아서더하기 {
	class Solution {
	    HashMap<Integer,Integer> map;
	    public int[] solution(int[] numbers) {
	        map=new HashMap<>();
	        int[] answer = {};
	        for(int i=0;i<numbers.length;i++){
	            for(int j=i+1;j<numbers.length;j++)
	                map.put(numbers[i]+numbers[j],1);
	        }
	        answer=new int[map.size()];
	        int idx=0;
	        for(Integer key:map.keySet()){
	            answer[idx]=key;
	            idx++;
	        }
	        Arrays.sort(answer);
	        return answer;
	    }
	}
}
