package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2529_부등호 {
	static int N;
	static char arr[];
	static boolean visit[];
	static long max;
	static long min;
	static String resultx,resultn;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=Integer.parseInt(sc.nextLine());
		arr=new char[N];
		String s[]=sc.nextLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i]=s[i].charAt(0);
		}
		max=Long.MIN_VALUE;
		min=Long.MAX_VALUE;
		for(int i=0;i<10;i++) {
			visit=new boolean[10];
			visit[i]=true;
			permu(i+"",0);
		}
		System.out.println(resultx);
		System.out.println(resultn);
	}
	static void permu(String temp,int idx) {
		if(idx==N) {
			if(max<Long.parseLong(temp)) {				
				max=Math.max(Long.parseLong(temp),max);
				resultx=temp;
			}
			if(min>Long.parseLong(temp)) {
				min=Math.min(Long.parseLong(temp),min);
				resultn=temp;
			}
			return;
		}
		for(int i=0;i<10;i++) {
			if(!visit[i]) {
				if((arr[idx]=='>'&&(temp.charAt(idx)-'0')<i)||
						(arr[idx]=='<'&&(temp.charAt(idx)-'0')>i)) continue;
				visit[i]=true;
				permu(temp+i,idx+1);
				visit[i]=false;
			}
		}
	}
}
