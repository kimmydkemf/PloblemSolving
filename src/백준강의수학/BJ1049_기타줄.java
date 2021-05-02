package 백준강의수학;
import java.util.*;

public class BJ1049_기타줄 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int pack[]=new int[M];
		int sole[]=new int[M];
		for(int i=0;i<M;i++) {
			pack[i]=sc.nextInt();
			sole[i]=sc.nextInt();
		}
		Arrays.sort(pack);
		Arrays.sort(sole);
		
		int min=Math.min(sole[0]*N,(N/6+1)*pack[0]);
		min=Math.min(min,(N/6)*pack[0]+(N%6)*sole[0]);
		System.out.println(min);
	}
}
