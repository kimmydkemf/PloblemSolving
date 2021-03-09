package 프로그래머스;

public class LEVEL3_DP_등굣길 {
	class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	        int answer = 0;
	        long [][] map=new long[200][200];
	        for(int[] t:puddles){
	            map[t[1]][t[0]]=-1;
	        }
	        map[1][1]=1;
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=m;j++){
	                if(i==1&&j==1) continue;
	                if(map[i][j]==-1){
	                    map[i][j]=0;
	                    continue;
	                }
	                map[i][j]=(map[i-1][j]+map[i][j-1])%1000000007;
	            }
	        }
	        // print(map);
	        answer=(int)(map[n][m]%1000000007);
	        return answer;
	    }
	    public void print(long[][]map){
	        for(long[] m:map){
	            for(long a:m){
	                System.out.print(a+" ");
	            }
	            System.out.println();
	        }
	    }
	}
}
