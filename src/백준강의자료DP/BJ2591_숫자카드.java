package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ2591_숫자카드 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] origin=sc.nextLine().toCharArray();
		char[] temp=new char[45];
		for(int i=0;i<origin.length;i++) temp[i]=origin[i];
		int dp[]=new int[45];
		dp[0]=1;
		for(int i=0;i<origin.length;i++) {
			int now=temp[i]-'0';
			if(now!=0) {
				dp[i+1]+=dp[i];
				if(now*10+temp[i+1]-'0'<=34) dp[i+2]+=dp[i];
			}
		}
		System.out.println(dp[origin.length]);
	}
}
