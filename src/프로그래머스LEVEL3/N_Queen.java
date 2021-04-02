package 프로그래머스LEVEL3;

public class N_Queen {
	class Solution {
	    int map[][];
	    boolean visit[];
	    int answer,N;
	    public int solution(int n) {
	        answer = 0;
	        N=n;
	        map=new int[N][N];
	        visit=new boolean[N];
	        for(int i=0;i<N;i++){
	            map[0][i]=1;
	            visit[i]=true;
	            dfs(1);
	            visit[i]=false;
	            map[0][i]=0;
	        }
	        return answer;
	    }
	    public void dfs(int idx){
	        if(idx==N){
	            answer++;
	            return;
	        }
	        for(int i=0;i<N;i++){
	            if(!visit[i]&&possible(idx,i)){
	                map[idx][i]=1;
	                visit[i]=true;
	                dfs(idx+1);
	                visit[i]=false;
	                map[idx][i]=0;
	            }
	        }
	    }
	    public boolean possible(int x,int y){
	        int lx=x-1,ly=y-1;
	        while(isIn(lx,ly)&&map[lx][ly]==0){
	            lx--;
	            ly--;
	        }
	        if(isIn(lx,ly)) return false;
	        int rx=x-1,ry=y+1;
	        while(isIn(rx,ry)&&map[rx][ry]==0){
	            rx--;
	            ry++;
	        }
	        if(isIn(rx,ry)) return false;
	        return true;
	    }
	    public boolean isIn(int x,int y){
	        return x>=0&&y>=0&&x<N&&y<N;
	    }
	}
}
