package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ17829_222_풀링 {
	static int N;
	static int [][] map;
	static int [] di= {0,1,0,1};
	static int [] dj= {0,0,1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(N!=1) {
			makeMatrix();
		}
		System.out.println(map[0][0]);
	}
	private static void makeMatrix() {
		N/=2;
		int newmap[][]=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int temp[]=new int[4];
				for(int k=0;k<4;k++) {
					int nx=i*2+di[k];
					int ny=j*2+dj[k];
					temp[k]=map[nx][ny];
				}
				Arrays.sort(temp);
				newmap[i][j]=temp[2];
			}
		}
		map=newmap;
	}
}
