package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ13335_트럭 {
	static int [] arr;
	static int [] truck;
	static int N,W,L;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		
		truck=new int[N];
		arr=new int[L];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			truck[i]=Integer.parseInt(st.nextToken());
		}
		int idx=0;
		int sum=0;
		int time=0;
		while(idx<N||sum!=0) {
			time++;
			sum-=arr[0];
			for(int i=1;i<L;i++) {
				arr[i-1]=arr[i];
			}
			arr[L-1]=0;
			if(idx<N&&sum+truck[idx]<=W) {
				sum+=truck[idx];
				arr[L-1]=truck[idx++];
			}
		}
		System.out.println(time);
	}
}
