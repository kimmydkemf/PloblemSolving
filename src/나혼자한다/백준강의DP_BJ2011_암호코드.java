package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ2011_암호코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int length=str.length();
		int dp[]=new int[length+1];
		dp[0]=1;
		for(int i=1;i<=length;i++) {
			int x=str.charAt(i-1)-'0';
			if(x>=1&&x<=9) {
				dp[i]+=dp[i-1];
			}
			if(i==1)
				continue;
			if(str.charAt(i-2)=='0') continue;
			x+=(str.charAt(i-2)-'0')*10;
			if(x>=10&&x<=26) {
				dp[i]+=dp[i-2];
			}
			dp[i]%=1000000;
		}
		System.out.println(dp[length]);
	}
}
