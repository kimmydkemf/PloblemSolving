package 백준강의자료DP;
import java.math.BigInteger;
import java.util.*;

public class BJ2407_조합 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		BigInteger result=BigInteger.ONE;
		BigInteger div=BigInteger.ONE;
		for(int i=0;i<m;i++) {
			result=result.multiply(BigInteger.valueOf(n-i));
			div=div.multiply(BigInteger.valueOf(i+1));
		}
		System.out.println(result.divide(div));
	}
}
