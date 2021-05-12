package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2669_직사각형네개의합집합의면적구하기 {
	static boolean[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new boolean[101][101];
		for(int i=0;i<4;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			for(int n=y1;n<y2;n++) {
				for(int m=x1;m<x2;m++) {
					map[n][m]=true;
				}
			}
		}
		int size=0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(map[i][j]) size++;
			}
		}
		System.out.println(size);
	}
}
