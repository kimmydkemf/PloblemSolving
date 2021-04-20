package 삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;

public class BJ3190_뱀 {
	static int N,K,L,d;
	static int [][]map;
	static int time;
	static Deque<Head> snake;
	static int [] di= {0,1,0,-1};
	static int [] dj= {1,0,-1,0};
	// -> 0, down 1, <- 2, up 3
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		K=Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a-1][b-1]=2;
		}
		L=Integer.parseInt(br.readLine());
		d=0;
		time=0;
		map[0][0]=1;
		snake=new LinkedList<>();
		snake.addFirst(new Head(0,0));
		boolean check=false;
		for(int i=0;i<L;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			char dir=st.nextToken().charAt(0);
//			System.out.println(d);
			if(!simulation(t)) {
				check=true;
				break;
			}
			//System.out.println();
			//print();
			//System.out.println("\n");
			switch(dir) {
			case 'D':
				d+=1;
				if(d==4) d=0;
				break;
			case 'L':
				d-=1;
				if(d<0) d=3;
				break;
			}
		}
		if(check)
			System.out.println(time);
		else {
			simulation(10000);
			System.out.println(time);
		}
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]);
			}
		System.out.println();
		}
	}
	static boolean simulation(int t) {
		while(time<t) {
			time++;
			Head now=snake.peek();
			int nx=now.x+di[d];
			int ny=now.y+dj[d];
			if(isIn(nx,ny)&&map[nx][ny]!=1) {
				if(map[nx][ny]!=2) {
					Head last = snake.pollLast();
					map[last.x][last.y]=0;
				}
				map[nx][ny]=1;
				snake.addFirst(new Head(nx,ny));
			}else {
				//System.out.println(nx+" "+ny);
				return false;
			}
		}
		return true;
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
	static class Head{
		int x,y;
		Head(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
