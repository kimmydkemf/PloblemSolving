package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2210_숫자판점프 {
	static HashMap<String,Integer> key;
	static int [][]map;
	static int di[]= {-1,1,0,0};
	static int dj[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		map=new int[5][5];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		key=new HashMap<>();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				go(i,j,0,map[i][j]+"");
			}
		}
		System.out.println(key.size());
	}
	static void go(int x,int y,int cnt,String t) {
		if(cnt==5) {
			if(!key.containsKey(t)) {
				key.put(t,1);
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int nx=x+di[i];
			int ny=y+dj[i];
			if(isIn(nx,ny)) {
				go(nx,ny,cnt+1,t+map[nx][ny]);
			}
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<5&&y<5;
	}
}
