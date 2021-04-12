package 프로그래머스LEVEL1;
import java.util.*;

public class 카카오2018블라인드_다트게임 {
	class Solution {
	    public int solution(String dartResult) {
	        int answer = 0;
	        Stack<Integer> stack=new Stack<>();
	        int len=dartResult.length();
	        String temp="";
	        for(int j=0;j<len;j++){
	            char a=dartResult.charAt(j);
	            if(a>='A'&&a<='Z'){
	                int i = Integer.parseInt(temp);
	                switch(a){
	                    case 'S':
	                        stack.push(i);
	                        break;
	                    case 'D':
	                        stack.push((int)Math.pow(i,2));
	                        break;
	                    case 'T':
	                        stack.push((int)Math.pow(i,3));
	                        break;
	                }
	                temp="";
	            }else if(a=='*'||a=='#'){
	                int d1=stack.pop();
	                int d2=0;
	                if(a=='#'){
	                    stack.push((-1)*d1);
	                    continue;
	                }
	                if(!stack.isEmpty()) d2=stack.pop();
	                if(d2!=0) stack.push(d2*2);
	                stack.push(d1*2);
	            }else{
	                temp+=a;
	            }
	        }
	        while(!stack.isEmpty()){
	            int t = stack.pop();
	            answer+=t;
	        }
	        return answer;
	    }
	}
}
