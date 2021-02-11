package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		
		int gcd=getGCD(Math.max(A,B),Math.min(A,B));
		int lcm=(A*B)/gcd;
		System.out.println(gcd+"\n"+lcm);
	}

	private static int getGCD(int max, int min) {
		while(min>0) {
			int temp=max;
			max=min;
			min=temp%min;
		}
		return max;
	}
}
