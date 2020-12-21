package 지나가다가;
import java.util.*;
import java.io.*;
	
public class BJ6588_골드바흐의추측 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int maxnum=1000000;
		boolean []check=new boolean[maxnum+1];
		check[0]=true;check[1]=true;
		String str="Goldbach's conjecture is wrong.";
		for(int i=2;i<=maxnum;i++) {
			if(!check[i]) {
				int next=i*2;
				while(next<=maxnum) {
					check[next]=true;
					next+=i;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		while(true) {
			int now=sc.nextInt();
			if(now==0)
				break;
			boolean tf=false;
			for(int i=3;i<=now;i+=2) {
				if(check[i]) {
					continue;
				}
				if(!check[now-i]) {
					tf=true;
					sb.append(now+" = "+i+" + "+(now-i)+"\n");
					break;
				}
			}
			if(!tf) {
				sb.append(str+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
