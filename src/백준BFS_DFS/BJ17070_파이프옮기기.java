package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ17070_파이프옮기기 {
	static int N;
	static int map[][];
	static int sum=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0,1);
		System.out.println(sum);
	}
	static void dfs(int leftx,int lefty,int rightx,int righty) {
		if(rightx==N-1&&righty==N-1) {
			sum++;
			return;
		}
		if(leftx==rightx) {
			if(isIn(rightx,righty+1)&&map[rightx][righty+1]==0) 
				dfs(leftx,lefty+1,rightx,righty+1);
			if(isIn(rightx+1,righty+1)&&checktrip(rightx,righty))
				dfs(leftx,lefty+1,rightx+1,righty+1);
		}else if(lefty==righty) {
			if(isIn(rightx+1,righty)&&map[rightx+1][righty]==0) 
				dfs(leftx+1,lefty,rightx+1,righty);
			if(isIn(rightx+1,righty+1)&&checktrip(rightx,righty))
				dfs(leftx+1,lefty,rightx+1,righty+1);
		}else {
			if(isIn(rightx,righty+1)&&map[rightx][righty+1]==0) 
				dfs(leftx+1,lefty+1,rightx,righty+1);
			if(isIn(rightx+1,righty)&&map[rightx+1][righty]==0) 
				dfs(leftx+1,lefty+1,rightx+1,righty);
			if(isIn(rightx+1,righty+1)&&checktrip(rightx,righty))
				dfs(leftx+1,lefty+1,rightx+1,righty+1);
		}
	}
	static boolean checktrip(int x,int y) {
		return map[x+1][y]==0&&map[x][y+1]==0&&map[x+1][y+1]==0;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
