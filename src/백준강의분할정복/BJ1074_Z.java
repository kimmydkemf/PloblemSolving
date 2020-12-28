package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ1074_Z {
	static int x,y;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();x=sc.nextInt();y=sc.nextInt();
		int size=(int) Math.pow(2,N);
		solve(0,0,size,0);
	}
	static void solve(int rangex,int rangey,int size,int count) {
		if(size<1)
			return;
		if(x==rangex&&y==rangey) {
			System.out.println(count);
			return;
		}
		int paper=size/2*size/2;
		if(x<rangex+size/2&&y<rangey+size/2) { // 1사분면.
			solve(rangex,rangey,size/2,count);
		}else if(x<rangex+size/2&&y>=rangey+size/2) {
			solve(rangex,rangey+size/2,size/2,count+paper);
		}else if(x>=rangex+size/2&&y<rangey+size/2) {
			solve(rangex+size/2,rangey,size/2,count+paper*2);
		}else {
			solve(rangex+size/2,rangey+size/2,size/2,count+paper*3);
		}
	}
}