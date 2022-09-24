package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1051_숫자정사각형 {
	static int N,M;
	static int [][]map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		int maxsize=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int size = startup(i,j);
				maxsize=Math.max(maxsize, size*size);
			}
		}
		System.out.println(maxsize);
	}
	private static int startup(int i, int j) {
		int start = 1;
		int end=1;
		int startx=i;
		int starty=j;
		while(i<N-1&&j<M-1) {
			i++;
			j++;
			end++;
			if(		map[i][j]==map[startx][j]&&
					map[i][j]==map[startx][starty]&&
					map[i][j]==map[i][starty]) start=end;
		}
		return start;
	}
	
}
