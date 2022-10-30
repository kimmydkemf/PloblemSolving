package 나혼자한다;

import java.util.Scanner;

public class BJ14888_연산자끼워넣기 {
	
	static int N;
	static int ops[];
	static int numbers[];
	static int max,min;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		numbers=new int[N];
		for(int i=0;i<N;i++) numbers[i]=sc.nextInt();
		ops=new int[4];
		for(int i=0;i<4;i++) ops[i]=sc.nextInt();
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		go(numbers[0],1);
		System.out.println(max+"\n"+min);
	}
	static void go(int sum,int k) {
		if(k==N) {
			max=Math.max(max, sum);
			min=Math.min(min, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(ops[i]>0) {
				ops[i]--;
				switch(i) {
				case 0:
					go(sum+numbers[k],k+1);
					break;
				case 1:
					go(sum-numbers[k],k+1);
					break;
				case 2:
					go(sum*numbers[k],k+1);
					break;
				case 3:
					go(sum/numbers[k],k+1);
				}
				ops[i]++;
			}
		}
	}
}
