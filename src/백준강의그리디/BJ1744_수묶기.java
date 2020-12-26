package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1744_수묶기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int []arr=new int[N];
		boolean []check=new boolean[N];
		int zero=0,one=0;
		ArrayList<Integer> plus,minus;
		plus=new ArrayList<>();
		minus=new ArrayList<>();
		for(int i=0;i<N;i++) {
			int now=sc.nextInt();
			if(now>1)
				plus.add(now);
			else if(now<0)
				minus.add(now);
			else if(now==1){
				one++;
			}
			else{
				zero++;
			}
		}
		Collections.sort(plus);
		Collections.reverse(plus);
		Collections.sort(minus);
		int sum=one;
		if(plus.size()%2==1) {
			plus.add(1);
		}
		if(minus.size()%2==1) {
			minus.add(zero>0?0:1);
		}
		for(int i=0;i<plus.size();i+=2) {
			sum+=plus.get(i)*plus.get(i+1);
		}
		for(int i=0;i<minus.size();i+=2) {
			sum+=minus.get(i)*minus.get(i+1);
		}
//		int end=plus.size()/2;
//		for(int i=0;i<end;i++) {
//			sum+=plus.get(2*i)*plus.get(2*i+1);
//		}
//		if(plus.size()%2!=0)
//			sum+=plus.get(plus.size()-1);
//		if(plus1!=0)
//			sum++;
//		end=minus.size()/2;
//		for(int i=0;i<end;i++) {
//			sum+=minus.get(2*i)*minus.get(2*i+1);
//		}
//		if(minus.size()%2!=0&&zero==0) {
//			sum+=minus.get(minus.size()-1);
//		}
		System.out.println(sum);
	}
}
