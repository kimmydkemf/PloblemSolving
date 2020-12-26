package 백준강의그리디;
import java.util.*;
import java.io.*;

/***
 * 
 * @author selordoun
 *	30의 배수가 되는 수.
 * 30,60,90,120,150,180,210,240,270,300
 * 330,360,390,420,450,480,510,540,570,600
 * 630,660,690,720,750,780,810,840,870,900
 * 930,960,990,1020,1050,1080,1110,1140,1170,1200
 * 0앞 1,2,3,4,5,6,7,8,9
 * 1앞 1,2,5,8,
 */

public class BJ10610_30 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringBuilder sb=new StringBuilder();
		int length=s.length();
		int[] arr=new int[10];int sum=0;
		for(int i=0;i<length;i++) {
			int now=s.charAt(i)-'0';
			sum+=now;
			arr[now]++;
		}
		if(arr[0]==0||sum%3!=0) {
			System.out.println(-1);
		}else {
			for(int i=9;i>=0;i--) {
				for(int j=0;j<arr[i];j++)
					sb.append(i);
			}
			System.out.println(sb.toString());
		}
	}
}
