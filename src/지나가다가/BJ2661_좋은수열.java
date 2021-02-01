package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ2661_좋은수열 {
	static int arr[];
	static int N;
	static boolean is_end=false;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N];
		backtracking("");
	}
	static void backtracking(String str) {
		if(is_end)
			return;
		if(str.length()==N) {
			System.out.println(str);
			is_end=true;
			return;
		}
		for(int i=1;i<=3;i++) {
			if(isAble(str+i)) {
				backtracking(str+i);
			}
		}
	}
	static boolean isAble(String str) {
		int len=str.length();
		for(int i=1;i<=len/2;i++) {
			String front=str.substring(len-(2*i),len-i);
			String end=str.substring(len-i,len);
			if(front.equals(end)) return false;
		}
		return true;
	}
}
