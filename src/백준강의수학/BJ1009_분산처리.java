	package 백준강의수학;
	import java.util.*;
	import java.io.*;
	
	public class BJ1009_분산처리 {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int TC=sc.nextInt();
			for(int tc=1;tc<=TC;tc++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				if(a==1) {
					System.out.println(1);
					continue;
				}
				int temp=go(a,b);
				System.out.println(temp==0?10:temp);
			}
		}
		static int go(int a,int b) {
			if(b==1) {
				if(a<=10)
					return a;
				else
					return a%10;
			}
			if(b%2==0) {
				int result=go(a,b/2);
				return (result*result)%10;
			}else {
				int result=go(a,b/2);
				return (result*result*a)%10;
			}
		}
	}
