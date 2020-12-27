package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ1780_종이의개수 {
	static int cnt[]; // -1 = 0, 0 = 1, 1= 2
	static int paper[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		paper=new int[N][N];
		cnt=new int[3];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				paper[i][j]=Integer.parseInt(st.nextToken());
		}
		check(0,0,N);
		for(int i=0;i<3;i++)
			System.out.println(cnt[i]);
	}
	static void check(int x,int y,int size) {
		boolean find=false;
		int start=paper[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(paper[i][j]!=start) {
					find=true;
					break;
				}
			}
			if(find)
				break;
		}
		if(find) {
			//divide gogo
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					check(x+i*(size/3),y+j*(size/3),size/3);
				}
			}
		}else {
			switch(start) {
			case -1:
				cnt[0]++;
				break;
			case 0:
				cnt[1]++;
				break;
			case 1:
				cnt[2]++;
				break;
			}
		}
	}
}
