package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ2747_피보나치수 {
	static long fibona[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		fibona=new long[46];
		System.out.println(fibo(N));
	}
	static long fibo(int N) {
		if(N==0) {
			return 0;
		}
		if(N==1) {
			return 1;
		}
		if(fibona[N]!=0) {
			return fibona[N];
		}
		return fibona[N]=fibo(N-1)+fibo(N-2);
	}
}
