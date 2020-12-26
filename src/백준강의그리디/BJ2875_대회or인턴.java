package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ2875_대회or인턴 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int women=sc.nextInt();
		int men=sc.nextInt();
		int K=sc.nextInt();
		int team=0;
		while(women+men>=K+3&&women>=2&&men>=1) {
			team++;
			women-=2;
			men-=1;
		}
		System.out.println(team);
	}
}
