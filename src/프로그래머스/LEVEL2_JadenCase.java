package 프로그래머스;

public class LEVEL2_JadenCase {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        int idx=-1;
	        for(int i=0;i<s.length();i++){
	            char temp=s.charAt(i);
	            if(temp==' '){
	                idx=i;
	                answer+=temp;
	                continue;
	            }
	            if((temp>='a'&&temp<='z')&&idx+1==i){
	                answer+=(temp+"").toUpperCase();
	            }else if((temp>='A'&&temp<='Z')&&idx+1!=i){
	                answer+=(temp+"").toLowerCase();
	            }else{
	                answer+=temp;
	            }
	        }
	        return answer;
	    }
	}
}
