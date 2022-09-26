package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ7785_회사에있는사람 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Set<String> people = new HashSet<String>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String person=st.nextToken();
			String command=st.nextToken();
			if(command.equals("enter")) {
				people.add(person);
			}else {
				people.remove(person);
			}
		}
		StringBuilder sb=new StringBuilder();
		String arr[]=new String[people.size()];
		int start=0;
		Iterator<String> iterset=people.iterator();
		while(iterset.hasNext()) {
			arr[start++]=iterset.next();
		}
		Arrays.sort(arr);
		start-=1;
		while(start>=0) {
			sb.append(arr[start--]+"\n");
		}
		System.out.println(sb.toString());
	}
}
