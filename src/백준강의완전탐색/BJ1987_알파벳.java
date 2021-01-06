package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1987_알파벳 {
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,-1,0,1};
	static char[][]map;
	static boolean[][] visit;
	static int cnt,R,C;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt(); C=sc.nextInt();
		map=new char[R][C];
		visit=new boolean[R][C];
		for(int i=0;i<R;i++) {
			String s=sc.next();
			for(int j=0;j<C;j++)
				map[i][j]=s.charAt(j);
		}
		cnt=0;
		dfs(0,0,"");
		System.out.println(cnt);
	}
	static void dfs(int x,int y,String s) {
		if(visit[x][y])
			return;
		s+=map[x][y];
		visit[x][y]=true;
		if(s.length()>cnt)
			cnt=s.length();
		for(int i=0;i<4;i++) {
			int nx=x+di[i];
			int ny=y+dj[i];
			if(nx>=0&&ny>=0&&nx<R&&ny<C&&!s.contains(map[nx][ny]+"")) {
				dfs(nx,ny,s);
			}
		}
		visit[x][y]=false;
	}
}
