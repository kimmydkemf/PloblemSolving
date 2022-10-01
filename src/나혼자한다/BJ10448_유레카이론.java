package 나혼자한다;

import java.util.Scanner;

public class BJ10448_유레카이론 {
	static int[] arr;
	static int now;
	static boolean check=false;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int TC=sc.nextInt();
		arr=new int[50];
		int n=1;
		while(true) {
			if(n*(n+1)/2>1000) break;
			arr[n]=n*(n+1)/2;
			n++;
		}
		for(int tc=1;tc<=TC;tc++) {
			check=false;
			now=sc.nextInt();
			find(0,1,0);
			if(check) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb.toString());
	}
	static void find(int result,int idx,int cnt) {
		if(check) return;
		if(result==now&&cnt==3) {
			check=true; 
			return;
		}
		if(arr[idx]==0||cnt==3) return;
		find(result+arr[idx],idx,cnt+1);
		find(result+arr[idx],idx+1,cnt+1);
		find(result,idx+1,cnt);
	}
}
