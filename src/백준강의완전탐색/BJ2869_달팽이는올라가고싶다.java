package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long A=Long.parseLong(st.nextToken());
		long B=Long.parseLong(st.nextToken());
		long V=Long.parseLong(st.nextToken());
		System.out.println((int)Math.ceil((double)(V-A)/(A-B))+1);
	}
}	
