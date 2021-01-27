package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2003_수들의합2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int [] arr=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		int left=0;
		int right=0;
		int cnt=0;
		while(left<N) {
			int sum=0;
			for(int i=right;i<=left;i++) {
				sum+=arr[i];
			}
			if(sum==M) {
				cnt++;
			}
			if(right==left||sum<=M)
				left++;
			else if(sum>M) {
				right++;
			}
		}
		System.out.println(cnt);
	}
}
