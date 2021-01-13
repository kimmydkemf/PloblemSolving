package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1520_내리막길 {
	static int [][] map;
	static int [][] dp;
	static int [] di= {0,-1,0,1};
	static int [] dj= {-1,0,1,0};
	static int R,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken());
		map=new int[R][C];
		dp=new int[R][C];
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
//		dfs(0,0);
//		dp[0][0]=1;
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				int max=0;
//				for(int k=0;k<3;k++) {
//					int nx=di[k]+i;
//					int ny=dj[k]+j;
//					if(isIn(nx,ny)&&map[nx][ny]>map[i][j]) {
//						max+=dp[nx][ny];
//					}
//				}
//				dp[i][j]=Math.max(dp[i][j],max);
//			}
//			for(int j=0;j<C;j++) {
//				int max=0;
//				for(int k=0;k<3;k++) {
//					int nx=di[k]+i;
//					int ny=dj[k]+j;
//					if(isIn(nx,ny)&&map[nx][ny]>map[i][j]) {
//						max+=dp[nx][ny];
//					}
//				}
//				dp[i][j]=Math.max(dp[i][j],max);
//			}
//		}
//		go(0,0);
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(go(0,0));
	}
	static int go(int x,int y) {
		if(x==R-1&&y==C-1)
			return 1;
		if(dp[x][y]>=0) return dp[x][y];
		dp[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx=x+di[i];
			int ny=y+dj[i];
			if(isIn(nx,ny)&&map[nx][ny]<map[x][y])
				dp[x][y]+=go(nx,ny);
		}
		return dp[x][y];
	}
//	static void dfs(int x,int y) {
//		if(visit[x][y])
//			return;
//		visit[x][y]=true;
//		dp[x][y]++;
//		for(int i=0;i<4;i++) {
//			int nx=di[i]+x;
//			int ny=dj[i]+y;
//			if(isIn(nx,ny)&&map[nx][ny]<map[x][y])
//				dfs(nx,ny);
//		}
//		visit[x][y]=false;
//	}
	static boolean isIn(int x,int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}
}
