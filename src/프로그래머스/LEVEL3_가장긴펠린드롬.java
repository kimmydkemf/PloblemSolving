package 프로그래머스;

public class LEVEL3_가장긴펠린드롬 {
	class Solution
	{
	    char[] c;
	    public int solution(String s)
	    {
	        int answer = 1;
	        int len=s.length();
	        if(len<2)
	            return len;
	        c=s.toCharArray();
	        for(int i=0;i<len-answer;i++){
	            answer=Math.max(answer,countPalin(i,len-1));
	        }
	        return answer;
	    }
	    public int countPalin(int start,int end){
	        for(int i=end;i>start;i--){
	            if(c[start]==c[i]&&isPalin(start,i)){
	                return i-start+1;
	            }
	        }
	        return 0;
	    }
	    boolean isPalin(int s,int e){
	        int mid=(e+1-s)/2;
	        while(mid>0){
	            if(c[s]!=c[e])
	                return false;
	            s++;
	            e--;
	            mid--;
	        }
	        return true;
	    }
	}
}
