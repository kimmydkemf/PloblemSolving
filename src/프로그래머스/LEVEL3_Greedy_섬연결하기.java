package 프로그래머스;
import java.util.*;

public class LEVEL3_Greedy_섬연결하기 {
	class Solution {
	    int [] parent;
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        parent=new int[n];
	        for(int i=0;i<n;i++)
	            parent[i]=i;
	        PriorityQueue<Line> pq=new PriorityQueue<>((Line a,Line b)->{
	            return a.cost-b.cost;
	        });
	        for(int i=0;i<costs.length;i++){
	            int s=costs[i][0];
	            int e=costs[i][1];
	            int c=costs[i][2];
	            pq.add(new Line(s,e,c));
	        }
	        int sum=0;
	        while(!pq.isEmpty()){
	            Line now=pq.poll();
	            if(find(now.start)==find(now.end)){
	                continue;
	            }
	            union(now.start,now.end);
	            sum+=now.cost;
	        }
	        return sum;
	    }
	    public void union(int x,int y){
	        x=find(x);
	        y=find(y);
	        if(x<y){
	            parent[y]=x;
	        }else{
	            parent[x]=y;
	        }
	    }
	    public int find(int x){
	        if(x==parent[x])
	            return x;
	        return x=find(parent[x]);
	    }
	    public class Line{
	        int start;
	        int end;
	        int cost;
	        Line(int s,int e,int c){
	            start=s;
	            end=e;
	            cost=c;
	        }
	    }
	}
}
