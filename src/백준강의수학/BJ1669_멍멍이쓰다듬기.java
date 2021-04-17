package 백준강의수학;
import java.util.*;

public class BJ1669_멍멍이쓰다듬기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int minus=B-A;
		int ssqr=(int)Math.sqrt(minus);
		int day=0;
		if(Math.pow(ssqr,2)==minus) {
			day=2*ssqr-1;
		}else {
			int now=(int)Math.pow(ssqr,2);
			day=2*ssqr-1;
			day+=Math.ceil((minus-now)/(float)ssqr);
		}
		System.out.println(day==-1?0:day);
	}
}
