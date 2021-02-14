package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1422_숫자의신 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		ArrayList<String> arr=new ArrayList<>();
		ArrayList<String> ans=new ArrayList<>();
		for(int i=0;i<K;i++) {
			String temp=br.readLine();
			arr.add(temp);
			ans.add(temp);
		}
		Collections.sort(arr,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length())
					return o1.length()-o2.length(); 
				return o1.compareTo(o2);
			}
		});
		StringBuilder sb=new StringBuilder();
		if(K!=N) {
			String now=arr.get(K-1);
			for(int i=N;i>K;i--)
				ans.add(now);
		}
		Collections.sort(ans,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o2.concat(o1).compareTo(o1.concat(o2));
			}
		});
		for(int i=0;i<N;i++)
			sb.append(ans.get(i));
		System.out.println(sb.toString());
	}
}
