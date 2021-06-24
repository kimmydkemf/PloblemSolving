package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ9251_LCS {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char [] s1=br.readLine().toCharArray();
		char [] s2=br.readLine().toCharArray();
		int dp[][]=new int[s1.length+1][s2.length+1];
		int max=0;
		for(int i=1;i<=s1.length;i++) {
			char now=s1[i-1];
			for(int j=1;j<=s2.length;j++) {
				if(now==s2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
				max=Math.max(dp[i][j],max);
			}
		}
		System.out.println(max);
	}
}
