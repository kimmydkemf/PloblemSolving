package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1986_체스 {
	static int N,M;
	static int [][]map;
	static boolean [][]check;
	static int []di= {-1,-1,-1,0,0,1,1,1};
	static int []dj= {-1,0,1,-1,1,-1,0,1};
	static int []ni= {-2,-2,-1,-1,1,1,2,2};
	static int []nj= {-1,1,-2,2,2,-2,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		check=new boolean[N][M];
		for(int i=1;i<=3;i++) {
			st=new StringTokenizer(br.readLine());
			int temp=Integer.parseInt(st.nextToken());
			for(int j=1;j<=temp;j++) {	// 1: queen, 2: knight
				int x1=Integer.parseInt(st.nextToken())-1;
				int y1=Integer.parseInt(st.nextToken())-1;
				map[x1][y1]=i;
				check[x1][y1]=true;
			}
		}
//		printmap();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					goqueen(i,j);
				}else if(map[i][j]==2){
					goknight(i,j);
				}
			}
		}
		int answer=find();
//		print();
		System.out.println(answer);
	}
	static void printmap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(check[i][j]?1:0);
			}
			System.out.println();
		}
	}
	static int find() {
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!check[i][j]) sum++;
			}
		}
		return sum;
	}
	static void goknight(int sx,int sy) {
		for(int i=0;i<8;i++) {
			int nx=sx+ni[i];
			int ny=sy+nj[i];
			if(isIn(nx,ny)) check[nx][ny]=true;
		}
	}
	static void goqueen(int sx,int sy) {
		for(int i=0;i<8;i++) {
			int nx=sx+di[i];
			int ny=sy+dj[i];
			while(isIn(nx,ny)&&map[nx][ny]==0) {
				check[nx][ny]=true;
				nx+=di[i];
				ny+=dj[i];
			}
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
}
