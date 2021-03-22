package 프로그래머스LEVEL2;

public class 배달 {
	class Solution {
	    int[][] map;
	    int max=987654321;
	    public int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        map=new int[N][N];
	        for(int i=0;i<N;i++){
	            for(int j=0;j<N;j++){
	                if(i==j) continue;
	                map[i][j]=max;
	            }
	        }
	        for(int[] r:road){
	            int s=r[0]-1;
	            int e=r[1]-1;
	            int c=r[2];
	            if(map[s][e]>c){
	                map[s][e]=c;
	                map[e][s]=c;
	            }
	        } 
	        dijkstra(N);
	        for(int i=0;i<N;i++){
	            if(map[0][i]<=K) answer++;
	        }
	        return answer;
	    }
	    public void dijkstra(int n){
	        for(int k=0;k<n;k++){
	            for(int i=0;i<n;i++){
	                for(int j=0;j<n;j++){
	                    if(map[i][j]>map[i][k]+map[k][j])
	                        map[i][j]=map[i][k]+map[k][j];
	                }
	            }
	        }
	    }
	}
}
