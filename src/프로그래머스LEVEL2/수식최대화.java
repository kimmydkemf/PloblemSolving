package 프로그래머스LEVEL2;
import java.util.*;

public class 수식최대화 {
	class Solution {
	    int [] visit;
	    String problem;
	    long answer;
	    public long solution(String expression) {
	        answer = 0;
	        problem=expression;
	        visit=new int[3]; // 1. + 2. - 3. *
	        for(int i=0;i<3;i++){
	            visit[i]=3;
	            permutation(1);
	            visit[i]=0;
	        }
	        return answer;
	    }
	    public long solve(){
	        Stack<Long> number=new Stack<>();
	        Stack<Character> operand=new Stack<>();
	        String temp="";
	        int len=problem.length();
	        for(int i=0;i<len;i++){
	            char now=problem.charAt(i);
	            if(now=='+'||now=='-'||now=='*'){
	                if(operand.isEmpty()){
	                    operand.push(now);
	                    number.push(Long.parseLong(temp));
	                }else{
	                    if(nowbig(now,operand.peek())){
	                        operand.push(now);
	                        number.push(Long.parseLong(temp));
	                    }else{
	                        number.push(Long.parseLong(temp));
	                        while(!operand.isEmpty()&&!nowbig(now,operand.peek())){
	                            long t1=number.pop();
	                            long t2=number.pop();
	                            char c=operand.pop();
	                            switch(c){
	                                case '+':
	                                    number.push(t1+t2);
	                                    break;
	                                case '-':
	                                    number.push(t2-t1);
	                                break;
	                                case '*':
	                                    number.push(t1*t2);
	                            }
	                        }
	                        operand.push(now);
	                    }
	                }
	                temp="";
	            }else{
	                temp+=now;
	            }
	        }
	        if(!temp.equals("")){
	            number.push(Long.parseLong(temp));
	        }
	        while(!operand.isEmpty()){
	            long t1=number.pop();
	            long t2=number.pop();
	            char c=operand.pop();
	            switch(c){
	                case '+':
	                    number.push(t1+t2);
	                    break;
	                case '-':
	                    number.push(t2-t1);
	                    break;
	                case '*':
	                    number.push(t1*t2);
	                    break;
	            }
	        }
	        return Math.abs(number.pop());
	    }
	    public boolean nowbig(char n,char t){
	        int n1=0,n2=0;
	        switch(n){
	            case '+': n1=0;break;
	                case '-': n1=1;break;
	                case '*': n1=2;break;
	        }
	        switch(t){
	            case '+': n2=0;break;
	                case '-': n2=1;break;
	                case '*': n2=2;break;
	        }
	        return visit[n1]>visit[n2];
	    }
	    public void permutation(int cnt){
	        if(cnt==3){
	            answer = Math.max(answer,solve());
	            return;
	        }
	        for(int i=0;i<3;i++){
	            if(visit[i]==0){
	                visit[i]=3-cnt;
	                permutation(cnt+1);
	                visit[i]=0;
	            }
	        }
	    }
	}
}
