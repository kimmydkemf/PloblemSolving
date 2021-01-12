package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ1764_듣보잡 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());
		TreeSet<String> see=new TreeSet<>();
		TreeSet<String> result=new TreeSet<>();
		for(int i=0;i<N;i++) {
			see.add(br.readLine());
		}
		for(int i=0;i<M;i++) {
			String temp=br.readLine();
			if(see.contains(temp)) {
				result.add(temp);
			}
		}
		Iterator it=result.iterator();
		StringBuilder sb=new StringBuilder();
		sb.append(result.size()+"\n");
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		System.out.println(sb.toString());
	}
}
 