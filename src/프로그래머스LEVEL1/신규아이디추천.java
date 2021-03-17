package 프로그래머스LEVEL1;

public class 신규아이디추천 {
	class Solution {
	    public String solution(String new_id) {
	        int len=new_id.length();
	        String result="";
	        for(int i=0;i<len;i++){
	            char now=new_id.charAt(i);
	            if(now>='A'&&now<='Z')
	                result+=(char)(now+32);
	            else result+=now;
	        }
	        // System.out.println("step1: "+result);
	        String result2="";
	        for(int i=0;i<len;i++){
	            char now=result.charAt(i);
	            if(now!='.'&&now!='-'&&now!='_'&&!(now>='0'&&now<='9')&&!(now>='a'&&now<='z'))
	                continue;
	            result2+=now;
	        }
	        // System.out.println("step2: "+result2);
	        len=result2.length();
	        int cnt=0;
	        result="";
	        for(int i=0;i<len;i++){
	            char now=result2.charAt(i);
	            if(now=='.'){
	                cnt++;
	            }else{
	                if(cnt>=1){
	                    result+=".";
	                }
	                cnt=0;
	                result+=now;
	            }
	        }
	        // System.out.println("step3: "+result);
	        len=result.length();
	        cnt=0;
	        result2="";
	        for(int i=0;i<len;i++){
	            char now=result.charAt(i);
	            if(now=='.'&&cnt==0){
	                continue;
	            }else{
	                cnt=1;
	                result2+=now;
	            }
	        }
	        // System.out.println("step4: "+result2);
	        len=result2.length();
	        result="";
	        if(len==0)
	            result="a";
	        else
	            result=result2;
	        // System.out.println("step5: "+result);
	        if(result.length()>=16)
	            result=result.substring(0,15);
	        len=result.length();
	        cnt=0;
	        result2="";
	        for(int i=len-1;i>=0;i--){
	            char now=result.charAt(i);
	            if(now!='.') break;
	            cnt++;
	        }
	        result2=result.substring(0,len-cnt);
	        // System.out.println("step6: "+result2);
	        len=result2.length();
	        result="";
	        if(len<=2){
	            result+=result2.charAt(0)+"";
	            result+=result2.charAt(len-1)+"";
	            result+=result2.charAt(len-1)+"";
	            return result;
	        }
	        return result2;
	    }
	}
}
