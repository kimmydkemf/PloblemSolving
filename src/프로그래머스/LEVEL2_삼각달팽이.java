package 프로그래머스;

public class LEVEL2_삼각달팽이 {
	class Solution {
	    int[][] map;
	    int[] di={1,0,-1};
	    int[] dj={0,1,-1};
	    public int[] solution(int n) {
	        int max=getmax(n);
	        int[] answer = new int[max];
	        int i=0,j=0,k=1;
	        map=new int[n][n];
	        map[i][j]=k;
	        while(k<max){
	            while(i+1<n&&k<max&&map[i+1][j]==0){
	                map[++i][j]=++k;
	            }
	            while(j+1<n&&k<max&&map[i][j+1]==0){
	                map[i][++j]=++k;
	            }
	            while(i-1>0&&j-1>0&&k<max&&map[i-1][j-1]==0){
	                map[--i][--j]=++k;
	            }
	        }
	        k=0;
	        for(i=0;i<n;i++){
	            for(j=0;j<=i;j++){
	                answer[k++]=map[i][j];
	            }
	        }
	        return answer;
	    }
	    int getmax(int n){
	        return n==1?1:getmax(n-1)+n;
	    }
	}
}
