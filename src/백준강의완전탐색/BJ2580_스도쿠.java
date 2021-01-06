package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2580_스도쿠 {
	static boolean[][] c1; // 열.
	static boolean[][] c2; // 행.
	static boolean[][] c3; // 박스.
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		arr=new int[81];
		c1=new boolean[9][10];
		c2=new boolean[9][10];
		c3=new boolean[9][10];
		for(int i=0;i<9;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int now=Integer.parseInt(st.nextToken());
				arr[i*9+j]=now;
				c1[i][now]=true;
				c2[j][now]=true;
				c3[square(i,j)][now]=true;
			}
		}
		go(0);
	}
	static void go(int z) {
		if(z==81) {
			// print
			StringBuilder sb=new StringBuilder();
			int n=0;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++)
					sb.append(arr[n++]+" ");
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}else {
			if(arr[z]!=0) {
				go(z+1);
			}else {
				for(int i=1;i<=9;i++) {
					if(!c1[z/9][i]&&!c2[z%9][i]&&!c3[square(z/9,z%9)][i]) {
						c1[z/9][i]=true;
						c2[z%9][i]=true;
						c3[square(z/9,z%9)][i]=true;
						arr[z]=i;
						go(z+1);
						arr[z]=0;
						c1[z/9][i]=false;
						c2[z%9][i]=false;   
						c3[square(z/9,z%9)][i]=false;
					}
				}
			}
		}
	}
	static int square(int i,int j) {
		return 3*(i/3) +(j/3);
	}
}
