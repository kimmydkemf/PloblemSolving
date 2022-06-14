package 나혼자한다;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1577_도로의개수 {
	static int[] ni= {1,0};
	static int[] nj= {0,1};
	static int N,M,K;
	static Bridge[] b;
	static long dp[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		b=new Bridge[K];
		for(int i=0;i<K;i++) {
			b[i]=new Bridge();
			int aa=sc.nextInt();
			int bb=sc.nextInt();
			int cc=sc.nextInt();
			int dd=sc.nextInt();
			if(aa==cc) {
				if(bb>dd) {
					b[i].startx=aa;
					b[i].starty=dd;
					b[i].endx=cc;
					b[i].endy=bb;
				}else {
					b[i].startx=aa;
					b[i].starty=bb;
					b[i].endx=cc;
					b[i].endy=dd;
				}
			}else {
				if(aa>cc) {
					b[i].startx=cc;
					b[i].starty=bb;
					b[i].endx=aa;
					b[i].endy=dd;
				}else {
					b[i].startx=aa;
					b[i].starty=bb;
					b[i].endx=cc;
					b[i].endy=dd;
				}
			}
		}
		Arrays.sort(b);
		dp=new long[M+1][N+1];
		boolean check[][] = new boolean[M+1][N+1];
		dp[0][0]=1;
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(0,0));
		check[0][0]=true;
		while(!q.isEmpty()) {
			Point now=q.poll();
//			System.out.println(now.x+" "+now.y);
//			Print(now.x,now.y);
//			System.out.println();
					for(int n=0;n<2;n++) {
						int dn=now.x+ni[n];
						int dm=now.y+nj[n];
						int bn=now.x-ni[n];
						int bm=now.y-nj[n];
						if(ispossible(dn,dm)&&!Bpossible(now.x,now.y,dn,dm)&&!check[dm][dn]) { // 점이 있고, 다리도 공사중이 아니면,
								q.add(new Point(dn,dm));
								check[dm][dn]=true;
						}
						if(ispossible(bn,bm)&&!Bpossible(bn,bm,now.x,now.y)) {
							dp[now.y][now.x]+=dp[bm][bn];
						}
					}
			}
//		Print(M,N);
		System.out.println(dp[M][N]);
		
	}
	static void Print(int x,int y) {
		for(int i=0;i<=M;i++) {
			for(int j=0;j<=N;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static boolean Bpossible(int sx,int sy,int ex,int ey) {
		for(int i=0;i<K;i++) {
			if(b[i].starty==sy&&b[i].startx==sx) {
				if(b[i].startx==sx&&b[i].endx==ex&&b[i].endy==ey) {
					return true;
				}
			}
		}
		return false;
	}
	static boolean ispossible(int a,int b) {
		return a>=0&&a<=N&&b>=0&&b<=M;
	}
	static class Bridge implements Comparable<Bridge> {
		int startx;
		int starty;
		int endx;
		int endy;
		@Override
		public int compareTo(Bridge o) {
			return this.starty-o.starty;
		}
	}
}
