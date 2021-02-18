package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ18428_감시피하기 {
	static int N;
	static char [][]map;
	static boolean flag;
	static ArrayList<Point> teacher;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		teacher=new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=st.nextToken().charAt(0);
				if(map[i][j]=='T')
					teacher.add(new Point(i,j));
			}
		}
		flag=false;
		dfs(0,0);
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	private static void dfs(int idx, int choice) {
		if(flag)
			return;
		if(idx==N*N)
			return;
		if(choice==3) {
			if(check()) {
				flag=true;
			}
			return;
		}
		int r=idx/N;
		int c=idx%N;
		if(map[r][c]=='X') {
			map[r][c]='O';
			dfs(idx+1,choice+1);
			map[r][c]='X';
		}
		dfs(idx+1,choice);
	}
	static boolean check() {
		boolean result=true;
		int size=teacher.size();
		for(int i=0;i<size;i++) {
			Point now=teacher.get(i);
			for(int d=0;d<4;d++) {
				int nx=now.x+dx[d];
				int ny=now.y+dy[d];
				while(isIn(nx,ny)&&map[nx][ny]!='O') {
					if(map[nx][ny]=='S')
						return false;
					nx+=dx[d]; ny+=dy[d];
				}
			}
		}
		return result;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
