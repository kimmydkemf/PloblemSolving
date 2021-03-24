package 프로그래머스LEVEL2;
import java.util.*;

public class 짝지어제거하기 {
	class Solution
	{
	    public int solution(String s)
	    {
	        int answer = 0;
	        Stack<Character> stack=new Stack<>();
	        for(int i=0;i<s.length();i++){
	            char now=s.charAt(i);
	            if(!stack.isEmpty()&&stack.peek()==now){
	                stack.pop();
	            }else
	                stack.push(now);
	        }
	        if(stack.isEmpty())
	            return 1;
	        return answer;
	    }
	}
}
