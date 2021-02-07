package 프로그래머스;

public class LEVEL3_DFS_BFS_네트워크 {
	class Solution {
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean visit[]=new boolean[n];
	        for(int i=0;i<n;i++){
	            if(!visit[i]){
	                dfs(i,n,visit,computers);
	                answer++;
	            }
	        }
	        return answer;
	    }
	    void dfs(int num,int size,boolean[] visit,int[][]computers){
	        visit[num]=true;
	        for(int i=0;i<size;i++){
	            if(computers[num][i]==1&&!visit[i])
	                dfs(i,size,visit,computers);
	        }
	    }
	}
}
