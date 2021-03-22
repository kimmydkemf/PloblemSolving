package 프로그래머스LEVEL2;
import java.util.*;

public class 카카오프렌즈컬러링북 {
	class Solution {
	    public boolean[][] check;
	    public int N,M;
	    public int di[]={0,0,-1,1};
	    public int dj[]={-1,1,0,0};
	    public int[] solution(int m, int n, int[][] picture) {
	        M=m;
	        N=n;
	        int[] answer = new int[2];
	        check=new boolean[m][n];
	        int cnt=0;
	        int max=0;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(!check[i][j]&&picture[i][j]!=0){
	                    int color=picture[i][j];
	                    max = Math.max(max,bfs(i,j,color,picture));
	                    cnt++;
	                }
	            }
	        }
	        answer[0] = cnt;
	        answer[1] = max;
	        return answer;
	    }
	    public int bfs(int x,int y,int color,int[][]picture){
	        int sum=0;
	        check[x][y]=true;
	        Queue<Point> q=new LinkedList<>();
	        q.add(new Point(x,y));
	        while(!q.isEmpty()){
	            Point now=q.poll();
	            sum++;
	            for(int n=0;n<4;n++){
	                int ni=di[n]+now.x;
	                int nj=dj[n]+now.y;
	                if(isIn(ni,nj)&&!check[ni][nj]&&picture[ni][nj]==color){
	                    q.add(new Point(ni,nj));
	                    check[ni][nj]=true;
	                }
	            }
	        }
	        return sum;
	    }
	    public boolean isIn(int x,int y){
	        return x>=0&&y>=0&&x<M&&y<N;
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
