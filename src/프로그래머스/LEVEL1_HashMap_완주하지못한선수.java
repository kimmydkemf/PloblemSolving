package 프로그래머스;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class LEVEL1_HashMap_완주하지못한선수 {

	class Solution {
	    public String solution(String[] participant, String[] completion) {
			HashMap<String, Integer> go=new HashMap<String, Integer>();
	        for(String part:participant){
	            go.put(part,go.getOrDefault(part,0)+1);
	        }
			for(String comp:completion) {
	            if(go.get(comp)==1)
				    go.remove(comp);
	            else
	                go.put(comp,go.get(comp)-1);
			}
			return go.keySet().iterator().next();
	    }
	}
}
