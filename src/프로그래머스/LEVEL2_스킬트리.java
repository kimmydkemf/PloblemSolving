package 프로그래머스;

public class LEVEL2_스킬트리 {
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        for(String now:skill_trees){
	            int size=skill.length();
	            int idx=0;
	            boolean check=true;
	            for(int i=0;i<now.length();i++){
	                if(now.charAt(i)!=skill.charAt(idx)){
	                    if((skill.substring(idx,size)).contains(now.charAt(i)+"")){
	                        check=false;
	                        break;
	                    }
	                }else{
	                    idx++;
	                }
	                if(idx==skill.length())
	                    break;
	            }
	            if(check) answer++;
	        }
	        return answer;
	    }
	}
}
