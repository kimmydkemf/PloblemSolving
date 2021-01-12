package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ7785_회사에있는사람 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		TreeSet<String> set=new TreeSet<>(new Comp());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String name=st.nextToken();
			String command=st.nextToken();
			switch(command) {
			case "enter":
				set.add(name);
				break;
			case "leave":
				set.remove(name);
				break;
			}
		}
		StringBuilder sb=new StringBuilder();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		System.out.println(sb.toString());
	}
	static class Comp implements Comparator<String>{
		@Override
		public int compare(String s1,String s2) {
			// TODO Auto-generated method stub
			return s2.compareTo(s1);
		}
		
	}
}
