package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ13305_주유소 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long distance[]=new long[N-1];
		long fuel[]=new long[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++)
			distance[i]=Long.parseLong(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			fuel[i]=Long.parseLong(st.nextToken());
		long sum=fuel[0]*distance[0];
		int nowcity=0;
		int nextcity=nowcity+1;
		while(nextcity<N-1) {
			if(fuel[nowcity]<fuel[nextcity]) {
				sum+=fuel[nowcity]*distance[nextcity];
			}else {
				sum+=fuel[nextcity]*distance[nextcity];
				nowcity=nextcity;
			}
			nextcity++;
		}
		System.out.println(sum);
	}
}
