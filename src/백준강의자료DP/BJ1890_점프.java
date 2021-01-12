package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1890_점프 {
	static int map[][];
	static long dp[][];
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		dp=new long[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		dp[1][1]=1;
		go(1,1);
		System.out.println(dp[N][N]);
	}
	static void go(int x,int y) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				// 왼쪽에서 자기로 올수 있는갯수.
				for(int k=1;k<=9;k++) {
					if(j-k<1)
						break;
					if(map[i][j-k]==k) {
						dp[i][j]+=dp[i][j-k];
					}
				}
				for(int k=1;k<=9;k++){
					if(i-k<1) {
						break;
					}
					if(map[i-k][j]==k) {
						dp[i][j]+=dp[i-k][j];
					}
				}
			}
		}
	}
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
