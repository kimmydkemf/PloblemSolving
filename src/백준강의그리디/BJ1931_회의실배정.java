package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1931_회의실배정 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<meet> arr=new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr.add(new meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		int size=arr.size();
		int nowtime=arr.get(0).end;
		int cnt=1;
		for(int i=1;i<size;i++) {
			meet now=arr.get(i);
//			if(now.start>nowtime) {
//				cnt++;
//				nowtime=now.end;
//			}
			if(now.start<nowtime)
				continue;
			cnt++;
			nowtime=now.end;
		}
		System.out.println(cnt);
	}
	static class meet implements Comparable<meet>{
		int start,end;
		meet(int s,int e){
			start=s;
			end=e;
		}
		@Override
		public int compareTo(meet o) {
			if(this.end==o.end)
				return this.start-o.end;
			return this.end-o.end;
		}
	}
}
