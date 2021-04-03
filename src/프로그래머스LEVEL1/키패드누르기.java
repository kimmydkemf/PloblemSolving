package 프로그래머스LEVEL1;

public class 키패드누르기 {
	class Solution {
	    int map[][];
	    public String solution(int[] numbers, String hand) {
	        String answer = "";
	        map=new int[4][3];
	        Point lh=new Point(3,0);
	        Point rh=new Point(3,2);
	        for(int i=0;i<numbers.length;i++){
	                int number=numbers[i];
	            if(number==1||number==4||number==7){
	                answer+="L";
	                if(number==1) lh=new Point(0,0);
	                else if(number==4) lh=new Point(1,0);
	                else lh=new Point(2,0);
	            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
	                answer+="R";
	                if(number==3) rh=new Point(0,2);
	                else if(number==6) rh=new Point(1,2);
	                else rh=new Point(2,2);
	            }else{
	                Point now=new Point(0,0);
	                switch(number){
	                    case 2:
	                        now=new Point(0,1);
	                        break;
	                    case 5:
	                        now=new Point(1,1);
	                        break;
	                    case 8:
	                        now=new Point(2,1);
	                        break;
	                    case 0:
	                        now=new Point(3,1);
	                        break;
	                }
	                if(diff(now,rh)>diff(now,lh)){
	                    answer+="L";
	                    lh=new Point(now.x,now.y);
	                }else if(diff(now,lh)>diff(now,rh)){
	                    answer+="R";
	                    rh=new Point(now.x,now.y);
	                }else{
	                    if(hand.equals("right")){
	                        answer+="R";
	                        rh=new Point(now.x,now.y);
	                    }else{
	                    answer+="L";
	                    lh=new Point(now.x,now.y);
	                    }
	                }
	            }
	        }
	        return answer;
	    }
	    public int diff(Point a,Point b){
	        return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	    }
	    public class Point{
	        int x,y;
	        Point(int x,int y){
	            this.x=x;
	            this.y=y;
	        }
	    }
	}
}
