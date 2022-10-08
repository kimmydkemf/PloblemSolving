package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987_알파벳 {
	static int R,C,result;
	static char map[][];
	static boolean check[][];
	static int di[]= {-1,0,1,0};
	static int dj[]= {0,-1,0,1};
	static boolean alphabet[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		check=new boolean[R][C];
		alphabet=new boolean[26];
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		result=0;
		dfs(0,0,1);
		System.out.println(result);
	}
	static void dfs(int a,int b,int cnt) {
		check[a][b]=true;
		alphabet[map[a][b]-'A']=true;
		for(int i=0;i<4;i++) {
			int ni=a+di[i];
			int nj=b+dj[i];
			if(isIn(ni,nj)&&!check[ni][nj]&&!alphabet[map[ni][nj]-'A']) {
				dfs(ni,nj,cnt+1);
			}
		}
		alphabet[map[a][b]-'A']=false;
		check[a][b]=false;
		result=Math.max(cnt, result);
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<R&&y<C;
	}
}
