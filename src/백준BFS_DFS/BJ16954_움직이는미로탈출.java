package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ16954_움직이는미로탈출 {
	static char map[][]=new char[8][8];
	static int[]di= {0,1,-1,0,1,-1,0,1,-1};
	static int[]dj= {0,0,0,1,1,1,-1,-1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> wall=new LinkedList<>();
		for(int i=7;i>=0;i--) {
			String temp=br.readLine();
			for(int j=0;j<8;j++) {
				if(temp.charAt(j)=='#') {
					wall.add(new Point(i,j));
				}
				map[i][j]=temp.charAt(j);
			}
		}
		boolean result=bfs(wall);
		System.out.println((result?1:0));
	}
	static boolean bfs(Queue<Point> wall) {
		Queue<Point> user=new LinkedList<>();
		user.add(new Point(0,0));
		while(!user.isEmpty()) {
			if(wall.size()==0)
				return true;
			int size=user.size();
			for(int i=0;i<size;i++) {
				Point now=user.poll();
				if(map[now.x][now.y]=='#') continue;
				for(int d=0;d<9;d++) {
					int ni=now.x+di[d];
					int nj=now.y+dj[d];
					if(isIn(ni,nj)&&map[ni][nj]!='#') {
						user.add(new Point(ni,nj));
					}
				}
			}
			size=wall.size();
			boolean[][] check=new boolean[8][8];
			for(int i=0;i<size;i++) {
				Point now=wall.poll();
				if(!check[now.x][now.y])
					map[now.x][now.y]='.';
				int nd=now.x-1;
				if(nd<0)
					continue;
				map[nd][now.y]='#';
				check[nd][now.y]=true;
				wall.add(new Point(nd,now.y));				
			}
		}
		return false;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<8&&y<8;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
