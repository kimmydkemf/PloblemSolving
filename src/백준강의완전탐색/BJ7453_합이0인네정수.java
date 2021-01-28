package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ7453_합이0인네정수 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int a[]=new int[N];
		int b[]=new int[N];
		int c[]=new int[N];
		int d[]=new int[N];
		int ab[]=new int[N*N];
		int cd[]=new int[N*N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
			d[i]=Integer.parseInt(st.nextToken());
		}
		int abCnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ab[abCnt]=a[i]+b[j];
				cd[abCnt]=c[i]+d[j];
				abCnt++;
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		int left=0;
		int right=cd.length-1;
		long ans=0;
		while(left<ab.length&&right>=0) {
			int Av=ab[left];
			int Bv=cd[right];
			long Ac=0,Bc=0;
			if(Av+Bv==0) {
				while(left<ab.length&&ab[left]==Av) {
					Ac++;
					left++;
				}
				while(right>=0&&cd[right]==Bv) {
					Bc++;
					right--;
				}
				ans+=Ac*Bc;
			}
			if(Av+Bv>0) {
				right--;
			}
			if(Av+Bv<0) {
				left++;
			}
		}
		System.out.println(ans);
	}
}
