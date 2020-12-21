package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ2004_조합0의개수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long N=sc.nextLong();
		long M=sc.nextLong();
		long two=0,five=0;
		for(long i=2;i<=N;i*=2)
			two+=N/i;
		for(long i=2;i<=M;i*=2)
			two-=M/i;
		for(long i=2;i<=N-M;i*=2)
			two-=(N-M)/i;
		for(long i=5;i<=N;i*=5)
			five+=N/i;
		for(long i=5;i<=M;i*=5)
			five-=M/i;
		for(long i=5;i<=(N-M);i*=5)
			five-=(N-M)/i;
		System.out.println(Math.min(two,five));
	}
}
