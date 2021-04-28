package 삼성SW역량테스트기출문제;
import java.util.*;
import java.io.*;

public class BJ17144_미세먼지안녕 {
	static int R,C,T;
	static int map[][];
	static int di[]= {-1,0,1,0};
	static int dj[]= {0,-1,0,1};
	static Point airT,airB;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		airT=new Point(-1,-1);
		map=new int[R][C];
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(airT.x==-1) airT=new Point(i,j);
					else airB=new Point(i,j);
				}
			}
		}
		for(int i=0;i<T;i++) {
			dumy();
//			print();
			clean();
//			print();
		}
		System.out.println(findnum());
	}
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int findnum() {
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0)
					sum+=map[i][j];
			}
		}
		return sum;
	}
	static void clean() {
		
		for(int y=airT.x-1;y>0;y--) {
			map[y][0]=map[y-1][0];
		}
		for(int x=0;x<C-1;x++) {
			map[0][x]=map[0][x+1];
		}
		for(int x=0;x<airT.x;x++) {
			map[x][C-1]=map[x+1][C-1];
		}
		for(int y=C-1;y>1;y--) {
			map[airT.x][y]=map[airT.x][y-1];
		}
		map[airT.x][1]=0;
		
		
		for(int x=airB.x+1;x<R-1;x++) {
			map[x][0]=map[x+1][0];
		}
		for(int y=0;y<C-1;y++) {
			map[R-1][y]=map[R-1][y+1];
		}
		for(int x=R-1;x>airB.x;x--) {
			map[x][C-1]=map[x-1][C-1];
		}
		for(int y=C-1;y>1;y--) {
			map[airB.x][y]=map[airB.x][y-1];
		}
		map[airB.x][1]=0;
		
	}
	static void dumy() {
		Queue<Point> dum=new LinkedList<>();
		int temp[][]=new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) temp[i][j]=-1;
				if(map[i][j]!=0&&map[i][j]!=-1) dum.add(new Point(i,j));
			}
		}
		while(!dum.isEmpty()) {
			Point now=dum.poll();
			int cnt=0;
			for(int i=0;i<4;i++) {
				int nx=now.x+di[i];
				int ny=now.y+dj[i];
				if(isIn(nx,ny)&&map[nx][ny]!=-1) {
					temp[nx][ny]+=map[now.x][now.y]/5;
					cnt++;
				}
			}
			temp[now.x][now.y]+=(map[now.x][now.y]-(map[now.x][now.y]/5)*cnt);
		}
		map=temp;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<R&&y<C;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
