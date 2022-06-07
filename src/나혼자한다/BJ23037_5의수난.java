package 나혼자한다;

import java.util.Scanner;

public class BJ23037_5의수난 {
	public static void main(String[] args) {
		int number=0;
		Scanner sc=new Scanner(System.in);
		number=sc.nextInt();
		int sum=0;
		for(int i=0;i<5;i++) {
			sum+=Math.pow(number%10,5);
			number/=10;
		}
		System.out.println(sum);
	}
}
