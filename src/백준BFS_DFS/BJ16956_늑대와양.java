package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ16956_늑대와양 {
	static int R,C;
	static char map[][];
	static int di[]= {-1,1,0,0};
	static int dj[]= {0,0,-1,1};
	static Queue<pos> w,s;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		w=new LinkedList<>();
		s=new LinkedList<>();
		for(int i=0;i<R;i++) {
			String temp=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=temp.charAt(j);
				if(map[i][j]=='W') {
					w.add(new pos(i,j));
				}else if(map[i][j]=='S') {
					s.add(new pos(i,j));
				}
			}
		}
		while(!s.isEmpty()) {
			pos now=s.poll();
			for(int i=0;i<4;i++) {
				int nx=now.x+di[i];
				int ny=now.y+dj[i];
				if(isIn(nx,ny)&&map[nx][ny]=='.') {
					map[nx][ny]='D';
				}
			}
		}
		if(!cango()) {
			System.out.println(0);
		}else {
			System.out.println(1);
			print();
		}
	}
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static boolean cango() {
		boolean visit[][]=new boolean[R][C];
		while(!w.isEmpty()) {
			pos now=w.poll();
			visit[now.x][now.y]=true;
			for(int i=0;i<4;i++) {
				int nx=now.x+di[i];
				int ny=now.y+dj[i];
				if(isIn(nx,ny)&&!visit[nx][ny]) {
					if(map[nx][ny]=='S') return false;
					if(map[nx][ny]=='.') {
						w.add(new pos(nx,ny));
					}
				}
			}
		}
		return true;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<R&&y<C;
	}
	static class pos{
		int x,y;
		pos(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
