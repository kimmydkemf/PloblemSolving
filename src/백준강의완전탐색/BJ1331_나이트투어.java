package 백준강의완전탐색;
import java.util.*;

public class BJ1331_나이트투어 {
	static boolean map[][];
	static String start;
	static int di[]= {-2,-2,-1,-1,1,1,2,2};
	static int dj[]= {-1,1,-2,2,-2,2,-1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		map=new boolean[6][6];
		String temp=sc.nextLine();
		start=temp;
		int nx=temp.charAt(0)-'A';
		int ny=temp.charAt(1)-'1';
		map[nx][ny]=true;
		for(int i=1;i<36;i++) {
			temp=sc.nextLine();
			if(poss(temp,nx,ny)) {
				nx=temp.charAt(0)-'A';
				ny=temp.charAt(1)-'1';
				map[nx][ny]=true;
			}else {
				System.out.println("Invalid");
				return;
			}
		}
		if(poss(start,nx,ny)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}
	static boolean poss(String t,int x,int y) {
		int tx=t.charAt(0)-'A';
		int ty=t.charAt(1)-'1';
		if(!t.equals(start)&&map[tx][ty]) return false;
		for(int i=0;i<8;i++) {
			if(tx==x+di[i]&&ty==y+dj[i]) {
				return true;
			}
		}
		return false;
	}
}
