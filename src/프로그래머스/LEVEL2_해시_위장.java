package 프로그래머스;
import java.util.*;

public class LEVEL2_해시_위장 {

	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 0;
	        HashMap<String,Integer> map=new HashMap<>();
	        for(String[] wear:clothes){
	            map.put(wear[1],map.getOrDefault(wear[1],0)+1);
	        }
	        if(map.size()==1){
	             Iterator<String> iter=map.keySet().iterator();
	            String key=iter.next();
	            return map.get(key);
	        }else{
	            Iterator<String> iter=map.keySet().iterator();
	            int sum=1;
	            while(iter.hasNext()){
	                String key=iter.next();
	                sum*=(map.get(key)+1);
	            }
	            return sum-1;
	        }
	    }
	}
}
