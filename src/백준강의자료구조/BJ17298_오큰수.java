package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ17298_오큰수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		int answer[]=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		for(int i=N-1;i>=0;i--) {
			if(i==N-1) {
				answer[i]=-1;
				continue;
			}
			int now=i;
			int pre=i+1;
			if(arr[now]<arr[pre]) {
				answer[now]=i+1;
			}else {
				while(answer[pre]!=-1) {
					pre=answer[pre];
					if(arr[now]<arr[pre]) {
						answer[now]=pre;
						break;
					}
				}
				if(answer[now]==0) answer[now]=-1;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append((answer[i]==-1?-1:arr[answer[i]])+" ");
		}
		System.out.println(sb.toString());
	}
}
