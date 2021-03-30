package 프로그래머스LEVEL3;
import java.util.*;

public class 하노이 {
	class Solution {
	    Queue<Point> q;
	    public int[][] solution(int n) {
	        int[][] answer = {};
	        q=new LinkedList<>();
	        hanoi(1,2,3,n);
	        int size=q.size();
	        answer=new int[size][2];
	        for(int i=0;i<size;i++){
	            Point now=q.poll();
	            answer[i][0]=now.from;
	            answer[i][1]=now.to;
	        }
	        return answer;
	    }
	    public void hanoi(int from,int dist,int to,int number){
	        if(number==1){
	            q.add(new Point(from,to));
	            return;
	        } 
	        hanoi(from,to,dist,number-1);
	        hanoi(from,dist,to,1);
	        hanoi(dist,from,to,number-1);
	    }
	    public class Point{
	        int from;
	        int to;
	        Point(int f,int t){
	            from=f;
	            to=t;
	        }
	    }
	}
}
