package 나혼자한다;

import java.util.Scanner;

public class BJ3040_백설공주와일곱난쟁이 {
	static int[] nine=new int[9];
	static int[] seven=new int[7];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int result=0;
		for(int i=0;i<9;i++) { nine[i]=sc.nextInt();
			result+=nine[i];
		}
		int first=-1;
		int second=-1;
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(result-nine[i]-nine[j]==100) {
					first=i;
					second=j;
					break;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(i!=first&&i!=second) {
				System.out.println(nine[i]);
			}
		}
	}
}
