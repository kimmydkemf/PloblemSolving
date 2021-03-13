package 프로그래머스;

public class LEVEL2_문자열압축 {
	class Solution {
	    public int solution(String s) {
	        int answer = s.length();
	        for(int i=1;i<=s.length()/2;i++){
	            int result=comp(s,i).length();
	            answer=Math.min(answer,result);
	        }
	        return answer;
	    }
	    public String comp(String str,int i){
	       int cnt=1;
	        String comprehension="";
	        String pattern="";
	        for(int j=0;j<=str.length()+i;j+=i){ // pattern을 넣고 추가로 한번 더 돌아야하므로 length()보다 i 만큼 늘려서 더 실행.
	            String now;
	            if(j>=str.length()){
	                now="";
	            }else if(str.length()<j+i){
	                now=str.substring(j);
	            }else{
	                now=str.substring(j,j+i);
	            }
	            
	            if(j!=0){   // 처음에는 pattern을 넣어야하므로 생략.
	                if(pattern.equals(now)){    // pattern == now 면 cnt+1
	                    cnt++;
	                }else if(cnt>=2){   // 일치하지 않고 이전 pattern이 cnt>=2면 숫자를 더해서 합치기.
	                    comprehension+=cnt+pattern;
	                    cnt=1;
	                }else{  // pattern 중복이 안되면 그냥 붙여주기.
	                    comprehension+=pattern;
	                }
	            }
	            pattern=now;
	        }
	        // System.out.println(comprehension);
	        return comprehension;
	    }
	}
}
