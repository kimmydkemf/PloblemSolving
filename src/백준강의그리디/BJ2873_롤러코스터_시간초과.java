package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ2873_롤러코스터_시간초과 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int [][]map=new int[C][R];
		int min=Integer.MAX_VALUE,minx=-1,miny=-1;
		for(int i=0;i<C;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<R;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(min>map[i][j]) {
					min=map[i][j];
					minx=i;miny=j;
				}
			}
		}
		if(C%2==1) {
			for(int i=0;i<C/2;i++) {
				for(int j=0;j<R-1;j++) {
					sb.append("R");
				}
				sb.append("D");
				for(int j=0;j<R-1;j++) {
					sb.append("L");
				}
				sb.append("D");
			}
			for(int j=0;j<R-1;j++) {
				sb.append("R");
			}
		}
		else if(R%2==1) {
			for(int i=0;i<R/2;i++) {
				for(int j=0;j<C-1;j++) {
					sb.append("D");
				}
				sb.append("R");
				for(int j=0;j<R-1;j++) {
					sb.append("U");
				}
				sb.append("R");
			}
			for(int j=0;j<R-1;j++) {
				sb.append("D");
			}
		}
		else {
			String start="",end="";
			//col 줄이기
			int sx=0,sy=0;
			while(sx+2<=minx) {
				for(int i=0;i<R-1;i++)
					start+="R";
				start+="D";
				for(int i=0;i<R-1;i++)
					start+="L";
				start+="D";
				sx+=2;
			}
			int ex=C-1,ey=R-1;
			while(ex-2>=minx) {
				for(int i=0;i<R-1;i++)
					end="L"+end;
				start+="U";
				for(int i=0;i<R-1;i++)
					end="L"+end;
				start+="U";
				ex-=2;
			}
			//row 줄이기
			while(sy+2<=miny) {
				start+="DRUR";
				sy+=2;
			}
			while(ey-2>=miny) {
				end="ULDL"+end;
				ey-=2;
			}
			if(sy==miny) {
				start+="RD";
			}else {
				start+="DR";
			}
			sb.append(start+end);
		}
		System.out.println(sb.toString());
	}
}
