package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ7568_덩치 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int [][]arr=new int[N][2];
		int []rank=new int[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			int weight=arr[i][0];
			int height=arr[i][1];
			int now=1;
			for(int j=0;j<N;j++) {
				if(arr[j][0]>weight&&arr[j][1]>height) {
					now++;
				}
			}
			rank[i]=now;
		}
		for(int i=0;i<N;i++) {
			System.out.print(rank[i]+" ");
		}
	}
}
