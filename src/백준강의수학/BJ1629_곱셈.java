package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ1629_곱셈 {
	static long C;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long A=sc.nextLong(); 
		long B=sc.nextLong();
		C=sc.nextLong();
		System.out.println(pow(A%C,B));
	}
	static long pow(long A,long B) {
		if(B==1)
			return A;
		else{
			long temp=pow(A,B/2);
			if(B%2==1)
				return ((temp*temp)%C*A)%C;
			else
				return (temp*temp)%C;
		}
	}
}
