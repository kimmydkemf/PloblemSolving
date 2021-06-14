package 백준강의자료구조;
import java.util.*;

public class BJ1427_소트인사이드 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int length=s.length();
		int arr[]=new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=Integer.parseInt(s.charAt(i)+"");
		}
		Arrays.sort(arr);
		for(int i=length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	}
}
