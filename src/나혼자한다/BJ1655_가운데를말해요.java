package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []list=new int[N];
		for(int i=0;i<N;i++) {
			int now=Integer.parseInt(br.readLine());
			list[i]=now;
			Arrays.sort(list);
			System.out.println(list[i/2]);
		}
	}
}
