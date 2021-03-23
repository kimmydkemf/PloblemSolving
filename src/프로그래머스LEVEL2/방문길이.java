package 프로그래머스LEVEL2;

public class 방문길이 {
	class Solution {
	    public boolean[][][] map;
	    public int solution(String dirs) {
	        int answer = 0;
	        map=new boolean[11][11][4]; // u,l,d,u
	        answer = go(5,5,dirs);
	        return answer;
	    }
	    public int go(int sx,int sy,String s){
	        int len=s.length();
	        int sum=0;
	        for(int i=0;i<len;i++){
	            char now=s.charAt(i);
	            switch(now){
	                case 'U':
	                    if(!isIn(sx,sy+1))
	                        break;
	                    if(!map[sx][sy][0]){
	                        sum++;
	                        map[sx][sy][0]=true;
	                        map[sx][sy+1][2]=true;
	                    }
	                    sy+=1;
	                    break;
	                case 'L':
	                    if(!isIn(sx-1,sy)) break;
	                    if(!map[sx][sy][1]){
	                        sum++;
	                        map[sx][sy][1]=true;
	                        map[sx-1][sy][3]=true;
	                    }
	                    sx-=1;
	                    break;
	                case 'D':
	                    if(!isIn(sx,sy-1)) break;
	                    if(!map[sx][sy][2]){
	                        sum++;
	                        map[sx][sy][2]=true;
	                        map[sx][sy-1][0]=true;
	                    }
	                    sy-=1;
	                    break;
	                case 'R':
	                    if(!isIn(sx+1,sy)) break;
	                    if(!map[sx][sy][3]){
	                        sum++;
	                        map[sx][sy][3]=true;
	                        map[sx+1][sy][1]=true;
	                    }
	                    sx+=1;
	            }
	        }
	        return sum;
	    }
	    public boolean isIn(int x,int y){
	        return x>=0&&y>=0&&x<=10&&y<=10;
	    }
	}
}
