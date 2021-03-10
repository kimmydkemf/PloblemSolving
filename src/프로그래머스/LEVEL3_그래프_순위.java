package 프로그래머스;
import java.util.*;

public class LEVEL3_그래프_순위 {
	class Solution {
	    public int solution(int n, int[][] results) {
	        int [][] map=new int[n+1][n+1];
	        int win,lose;
	        for(int[] arr:map){
	            Arrays.fill(arr,987654321);
	        }
	        for(int i=0;i<=n;i++){
	            for(int j=0;j<=n;j++){
	                if(i==j) map[i][j]=0;
	            }
	        }
	        for(int[] r:results){
	            win=r[0];
	            lose=r[1];
	            map[win][lose]=1;
	        }
	        for(int k=1;k<=n;k++){
	            for(int i=1;i<=n;i++){
	                for(int j=1;j<=n;j++){
	                    if(map[i][j]>map[i][k]+map[k][j])
	                        map[i][j]=map[i][k]+map[k][j];
	                }
	            }
	        }
	        int sum=n;
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=n;j++){
	                if(i==j) continue;
	                if(map[i][j]==987654321&&map[j][i]==987654321){ 
	                    sum--;
	                    break;                    
	                }
	            }
	        }
	        return sum;
	    }
	}
}
