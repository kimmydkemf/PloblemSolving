package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ1935_후위표기식{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		int [] arr=new int[N];
		String temp=sc.nextLine();
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(sc.nextLine());
		}
		int length=temp.length();
		Stack<Double> stack=new Stack<>();
		for(int i=0;i<length;i++) {
			char t=temp.charAt(i);
			if(t>='A'&&t<='Z') {
				stack.push((double)arr[t-'A']);
			}else {
				double a=stack.pop();
				double b=stack.pop();
				double result=0;
				switch(t) {
				case '+':
					result=a+b;
					break;
				case '-':
					result=b-a;
					break;
				case '*':
					result=a*b;
					break;
				case '/':
					result=b/a;
					break;
				}
				stack.push(result);
			}
		}
		System.out.println(String.format("%.2f",stack.pop()));
	}
}
