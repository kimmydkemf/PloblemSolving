package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ1509_팰린드롬분할 {
	static int c[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int size=s.length();
		c=new int[size+1][size+1];
		for(int i=size;i>=1;i--) {
			for(int j=i;j<=size;j++) {
				if(i==j) {
					c[i][j]=1;
				}else if(j==i+1) {
					if(s.charAt(i-1)==s.charAt(j-1)) {
						c[i][j]=1;
					}else
						c[i][j]=0;
				}else {
					if(s.charAt(i-1)==s.charAt(j-1)&&c[i+1][j-1]==1) {
						c[i][j]=1;
					}else {
						c[i][j]=0;
					}
				}
			}
		}
		int [] D=new int[size+1];
		for(int i=1;i<=size;i++) {
			D[i]=Integer.MAX_VALUE;
			for(int j=1;j<=i;j++) {
				if(c[j][i]==1) {
					D[i]=Math.min(D[i],D[j-1]+1);
//					if(i==2)
//						System.out.println(j);
				}
			}
		}
		System.out.println(D[size]);
	}
}
