package 삼성SW역량테스트기출문제;
import java.util.*;
import java.io.*;

public class BJ16235_나무재테크 {
	static int [][] map;
	static int [][] value;
	static int [][] treecnt;
	static int N,M,K;
	static int di[]= {-1,-1,-1,0,0,1,1,1};
	static int dj[]= {-1,0,1,-1,1,-1,0,1};
	static PriorityQueue<Tree> pq;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		value=new int[N][N];
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				value[i][j]=Integer.parseInt(st.nextToken());
				map[i][j]=5;
			}
		}
		pq=new PriorityQueue<>((Tree a,Tree b)->{
			return a.old-b.old;
		});
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int o=Integer.parseInt(st.nextToken());
			pq.add(new Tree(x-1,y-1,o));
		}
		for(int i=0;i<K;i++) {
			if(pq.size()==0) break;
			treecnt=new int[N][N];
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(pq.size());
	}
	static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=value[i][j];
			}
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
	static void fall() {
		Queue<Tree> q=new LinkedList<>();
		while(!pq.isEmpty()) {
			Tree now = pq.poll();
			if(now.old%5==0) {
				for(int i=0;i<8;i++) {
					int nx=now.x+di[i];
					int ny=now.y+dj[i];
					if(isIn(nx,ny)) q.add(new Tree(nx,ny,1));
				}
			}
			q.add(new Tree(now.x,now.y,now.old));
		}
		while(!q.isEmpty()) {
			pq.add(q.poll());
		}
	}
	static void summer() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]+=treecnt[i][j];
			}
		}
	}
	static void spring() {
		Queue<Tree> q=new LinkedList<>();
		while(!pq.isEmpty()) {
			Tree now = pq.poll();
			if(map[now.x][now.y]<now.old) {
				treecnt[now.x][now.y]+=now.old/2;
				continue;
			}
			map[now.x][now.y]-=now.old;
			q.add(new Tree(now.x,now.y,now.old+1));
		}
		while(!q.isEmpty()) {
			pq.add(q.poll());
		}
	}
	static class Tree{
		int x,y,old;
		Tree(int x,int y,int o){
			this.x=x;
			this.y=y;
			this.old=o;
		}
	}
}
