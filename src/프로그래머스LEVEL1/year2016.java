package 프로그래머스LEVEL1;

public class year2016 {
	class Solution {
	    public String solution(int a, int b) {
	        String answer = "";
	        /*
	        1 - 31 2- 29 3-31 4-30 5-31 6-30 7-31 8-31 9-30 10-31 11-30 12-31
	        */
	        int days=0;
	        for(int i=1;i<a;i++){ // 월계산.
	            if(i<8){
	                if(i==2) days+=29;
	                else if(i%2==1) days+=31;
	                else days+=30;
	            }else{
	                if(i%2==0) days+=31;
	                else days+=30;
	            }
	        }
	        days+=b-1;
	        switch(days%7){
	            case 0:
	                answer="FRI";
	                break;
	            case 1: answer="SAT";
	                break;
	                case 2: answer="SUN";
	                break;
	                case 3: answer="MON";
	                break;
	                case 4:answer="TUE";
	                break;
	                case 5:answer="WED";
	                break;
	                case 6:answer="THU";
	                break;
	                
	        }
	        return answer;
	    }
	}
}
