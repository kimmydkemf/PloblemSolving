package 백준강의그리디;
import java.util.*;
import java.io.*;
/***
 * 
 * @author selordoun
 */
public class BJ1783_병든나이트 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int H=sc.nextInt();
		int W=sc.nextInt();
		if(H==1) {
			System.out.println(1);
		}else if(H==2) {
			System.out.println(Math.min(4,(W+1)/2));
		}else {
			if(W<7) {
				System.out.println(Math.min(4,W));
			}else {
				System.out.println(W-2);
			}
		}
	}
}
