package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ1189_컴백홈 {
	static int R,C,K,cnt;
	static char [][]map;
	static boolean visit[][];
	static int di[]= {-1,1,0,0};
	static int dj[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		cnt=0;
		map=new char[R][C];
		visit=new boolean[R][C];
		for(int i=0;i<R;i++) {
			String t=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=t.charAt(j);
			}
		}
		dfs(R-1,0,1);
		System.out.println(cnt);
	}
	static void dfs(int x,int y,int sum) {
		if(x==0&&y==C-1) {
			if(sum==K)
				cnt++;
			return;
		}
		visit[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx=x+di[i];
			int ny=y+dj[i];
			if(isIn(nx,ny)&&!visit[nx][ny]&&map[nx][ny]=='.') {
				dfs(nx,ny,sum+1);
			}
		}
		visit[x][y]=false;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<R&&y<C;
	}
	static class Point{
		int x,y;
		int length;
		Point(int x,int y){
			this.x=x;
			this.y=y;
			length=0;
		}
	}
}
