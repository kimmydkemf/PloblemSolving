package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1476_날짜계산 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// E= 1~15 S=1~28 M= 1~19
		int E=sc.nextInt(); int S=sc.nextInt(); int M=sc.nextInt();
		int cnt=1;
		int three[]=new int[3];
		three[0]=1;
		three[1]=1;
		three[2]=1;
		while(true) {
			if(E==three[0]&&S==three[1]&&M==three[2]) {
				break;
			}
			for(int i=0;i<3;i++)
				three[i]++;
			if(three[0]>15)three[0]=1;
			if(three[1]>28)three[1]=1;
			if(three[2]>19)three[2]=1;
			cnt++;
		}
		System.out.println(cnt);
	}
}
