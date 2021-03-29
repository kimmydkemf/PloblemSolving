package 프로그래머스LEVEL1;

public class 이상한문자만들기 {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        int idx=0;
	        for(int i=0;i<s.length();i++){
	            char temp=s.charAt(i);
	            if(temp==' '){
	                idx=0;
	                answer+=" ";
	                continue;
	            }
	            if(idx%2==0){
	                    if(temp>='A'&&temp<='Z') answer+=temp;
	                    else answer+=(char)(temp-32);
	                }
	                else{
	                    if(temp>='A'&&temp<='Z') answer+=(char)(temp+32);
	                    else answer+=temp;
	                }
	            idx++;
	        }
	        return answer;
	    }
	}
}
