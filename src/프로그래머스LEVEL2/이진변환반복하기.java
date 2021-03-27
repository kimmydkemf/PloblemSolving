package 프로그래머스LEVEL2;

public class 이진변환반복하기 {
	class Solution {
	    public int cnt=0,cnt0=0;
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        binary(s);
	        answer[0]=cnt;answer[1]=cnt0;
	        return answer;
	    }
	    public void binary(String s){
	        cnt++;
	        int len=0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='0'){
	                cnt0++;
	            }else{
	                len++;
	            }
	        }
	        if(len==1){
	            return;
	        }else{
	            String temp=make2(len);
	            binary(temp);
	        }
	    }
	    public String make2(int i){
	        String temp="";
	        while(i>0){
	            temp=i%2+temp;
	            i/=2;
	        }
	        return temp;
	    }
	}
}
