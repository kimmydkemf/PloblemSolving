package 프로그래머스;
import java.util.*;
import java.io.*;

public class LEVEL2_올바른괄호 {
	class Solution {
	    boolean solution(String s) {
	        Stack<Character> stack=new Stack<>();
	        for(int i=0;i<s.length();i++){
	            char now=s.charAt(i);
	            if(now=='(')
	                stack.push(now);
	            else{
	                if(stack.isEmpty())
	                    return false;
	                stack.pop();
	            }
	        }
	        if(stack.isEmpty())
	            return true;
	        return false;
	    }
	}
}
