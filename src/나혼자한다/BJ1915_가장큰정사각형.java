package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1915_가장큰정사각형 {
	static int N,M;
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		int cnt=0;
		for(int i=0;i<N;i++) {
			String now=br.readLine();
			for(int j=0;j<M;j++) {
				int a=(now.charAt(j)-'0');
				map[i][j]=a;
				if(a!=0) {
					int insert=1;
					if(isposs(i,j)) {
						map[i][j]=Math.min(map[i-1][j-1],Math.min( map[i-1][j],map[i][j-1]))+1;
						insert=map[i][j];
					}
					cnt=Math.max(cnt, insert);
				}
			}
		}
		System.out.println(cnt*cnt);
	}
	static boolean isposs(int i,int j) {
		return i-1>=0&&j-1>=0;
	}
}
