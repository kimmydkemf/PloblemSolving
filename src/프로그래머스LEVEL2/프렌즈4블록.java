package 프로그래머스LEVEL2;
import java.util.*;

public class 프렌즈4블록 {
	class Solution {
	    char map[][];
	    int M,N;
	    int di[]={0,0,1,1};
	    int dj[]={0,1,0,1};
	    public int solution(int m, int n, String[] board) {
	        map=new char[m][n];
	        M=m;N=n;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                map[i][j] = board[i].charAt(j);
	            }
	        }
	        int answer = count();
	        while(true){
	            // print();
	            if(simulation()){
	                break;
	            }
	        }
	        answer -= count();
	        return answer;
	    }
	    public void print(){
	        for(int i=0;i<M;i++){
	            for(int j=0;j<N;j++){
	                if(map[i][j]==0)
	                    System.out.print(" ");
	                else
	                    System.out.print(map[i][j]);
	            }
	            System.out.println();
	        }
	    }
	    public boolean simulation(){
	        Queue<Point> queue=new LinkedList<>();
	        for(int i=0;i<M;i++){
	            for(int j=0;j<N;j++){
	                char t = map[i][j];
	                if(t==0) continue;
	                if(find(t,i,j)) queue.add(new Point(i,j));
	            }
	        }
	        if(queue.isEmpty()) return true;
	        while(!queue.isEmpty()){
	            Point now=queue.poll();
	            for(int i=0;i<4;i++){
	                int nx=now.x+di[i];
	                int ny=now.y+dj[i];
	                map[nx][ny]=0;
	            }
	        }
	        for(int i=0;i<N;i++){
	            for(int j=M-2;j>=0;j--){
	                if(map[j][i]==0||map[j+1][i]!=0) continue;
	                char t=map[j][i];
	                map[j][i]=0;
	                int k=j+1;
	                while(k<M&&map[k][i]==0) k++;
	                map[k-1][i]=t;
	            }
	        }
	        return false;
	    }
	    public boolean find(char t,int nowx,int nowy){
	        for(int i=1;i<4;i++){
	            int nx=nowx+di[i];
	            int ny=nowy+dj[i];
	            if(isIn(nx,ny)&&map[nx][ny]==t) continue;
	            return false;
	        }
	        return true;
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
	    public int count(){
	        int cnt=0;
	        for(int i=0;i<M;i++){
	            for(int j=0;j<N;j++){
	                if(map[i][j]==0) continue;
	                cnt++;
	            }
	        }
	        return cnt;
	    }
	}
}
