package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ1181_단어정렬 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		letter [] arr=new letter[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=new letter(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb=new StringBuilder();
		sb.append(arr[0].s+"\n");
		for(int i=1;i<N;i++) {
			if(arr[i].s.compareTo(arr[i-1].s)!=0)
				sb.append(arr[i].s+"\n");
		}
		System.out.println(sb.toString());
	}
	static class letter implements Comparable<letter>{
		String s;
		int length;
		letter(String s){
			this.s=s;
			length=s.length();
		}
		@Override
		public int compareTo(letter o) {
			if(this.length==o.length) {
				return s.compareTo(o.s);
			}
			return this.length-o.length;
		}
		
	}
}
