package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ18870_좌표압축 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int arr[]=new int[N];
		int clone[]=new int[N];
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			arr[i]=a;
			clone[i]=a;
		}
		Arrays.sort(arr);
		Map<Integer,Integer> map=new HashMap<>();
		int idx=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], idx++);
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(map.get(clone[i])+" ");
		}
		System.out.println(sb.toString());
	}
}
