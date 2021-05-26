package 백준강의그리디;
import java.util.*;

public class BJ10162_전자레인지 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=300;
		int B=60;
		int C=10;
		int answer[]=new int[3];
		int T=sc.nextInt();
		if(T>=A) {
			answer[0]=T/A;
			T-=answer[0]*A;
		}
		if(T>=B) {
			answer[1]=T/B;
			T-=answer[1]*B;
		}
		if(T>=C) {
			answer[2]=T/C;
			T-=answer[2]*C;
		}
		if(T==0) {
			System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
		}else {
			System.out.println(-1);
		}
	}
}
