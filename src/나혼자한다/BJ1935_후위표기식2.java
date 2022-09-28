package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1935_후위표기식2 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String str=br.readLine();
		double array[]=new double[N];
		for(int n=0;n<N;n++) array[n]=Integer.parseInt(br.readLine());
		int size=str.length();
		Stack<Double> stack = new Stack<>();
		for(int s=0;s<size;s++) {
			char c = str.charAt(s);
			if(c>='A'&&c<='Z') {
				stack.push(array[c-'A']);
			}else {
				double a=stack.pop();
				double b=stack.pop();
				switch(c) {
				case '+':
					stack.push(a+b);
					break;
				case '-':
					stack.push(b-a);
					break;
				case '/':
					stack.push(b/a);
					break;
				case '*':
					stack.push(b*a);
					break;
				}
			}
		}
		System.out.println(String.format("%.2f",stack.pop()));
	}
}
