package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1347_미로만들기 {
	static boolean [][]map=new boolean[101][101];
	static int dir=0; // 0: South, 1: East, 2: North, 3:West
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String temp=br.readLine();
		
		int nx=50,maxx=50,minx=50;
		int ny=50,maxy=50,miny=50;
		map[nx][ny]=true;
		for(int i=0;i<N;i++) {
			switch(temp.charAt(i)){
			case 'R':
				dir-=1;
				if(dir<0) dir=3;
				break;
			case 'L':
				dir+=1;
				if(dir>3) dir=0;
				break;
			case 'F':
				switch(dir) {
				case 0:
					nx+=1;
					maxx=Math.max(maxx,nx);
					break;
				case 1:
					ny+=1;
					maxy=Math.max(maxy,ny);
					break;
				case 2:
					nx-=1;
					minx=Math.min(minx,nx);
					break;
				case 3:
					ny-=1;
					miny=Math.min(miny,ny);
					break;
				}
				map[nx][ny]=true;
				break;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=minx;i<=maxx;i++) {
			for(int j=miny;j<=maxy;j++) {
				sb.append(map[i][j]?'.':'#');
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
