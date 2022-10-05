package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1449_수리공항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		boolean arr[]=new boolean[1001];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(st.nextToken())]=true;
		}
		int cnt=0;
		for(int i=0;i<=1000;) {
			if(arr[i]==true) {
				cnt++;
				i+=L;
			}else {
				i++;
			}
		}
		System.out.println(cnt);
	}
}
