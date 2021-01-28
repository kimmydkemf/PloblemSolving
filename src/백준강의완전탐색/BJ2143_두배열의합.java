package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2143_두배열의합 {
	static long T;
	static int N,M;
	static int[] Narr,Marr;
	static ArrayList<Long> Alist,Blist;
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		T=sc.nextLong();
		N=sc.nextInt();
		Narr=new int[N];
		for(int i=0;i<N;i++)
			Narr[i]=sc.nextInt();
		Alist=new ArrayList<>();
		for(int i=0;i<N;i++) {
			long sum=0;
			for(int j=i;j<N;j++) {
				sum+=Narr[j];
				Alist.add(sum);
			}
		}
		M=sc.nextInt();
		Marr=new int[M];
		for(int i=0;i<M;i++)
			Marr[i]=sc.nextInt();
		Blist=new ArrayList<>();
		for(int i=0;i<M;i++) {
			long sum=0;
			for(int j=i;j<M;j++) {
				sum+=Marr[j];
				Blist.add(sum);
			}
		}
		Collections.sort(Alist);
		Collections.sort(Blist);
		int left=0;
		int right=Blist.size()-1;
		long ans=0;
		while(left<Alist.size()&&right>=0) {
			long Lv=Alist.get(left);
			long Rv=Blist.get(right);
			if(Lv+Rv==T) {
				long Lc=0;
				long Rc=0;
				while(left<Alist.size()&&Alist.get(left)==Lv) {
					left++;
					Lc++;
				}
				while(right>=0&&Blist.get(right)==Rv) {
					right--;
					Rc++;
				}
				ans+=Lc*Rc;
			}
			if(Lv+Rv>T) {
				right--;
			}
			if(Lv+Rv<T) {
				left++;
			}
		}
		System.out.println(ans);
	}
	
}
