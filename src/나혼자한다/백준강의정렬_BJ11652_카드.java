package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의정렬_BJ11652_카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		long[] arr=new long[N];
		for(int i=0;i<N;i++)
			arr[i]=Long.parseLong(br.readLine());
		Arrays.sort(arr);
		long now=arr[0];
		long result=now;
		int cnt=0;
		int cntnow=1;
		for(int i=1;i<N;i++) {
//			System.out.print(arr[i]+"\t");
			if(now==arr[i]) {
				cntnow++;
			}else {
				if(cnt<cntnow) {
					result=now;
					cnt=cntnow;
				}
				cntnow=1;
				now=arr[i];
			}
		}
		if(cnt<cntnow)
			result=now;
		System.out.println(result);
//			sb.append(arr[i]+"\n");
//		System.out.println(sb.toString());
			
	}
}
