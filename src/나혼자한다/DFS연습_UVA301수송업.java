package 나혼자한다;

import java.util.Scanner;

/***
 * 
 * @author isangho
 * 문제정리
 * A -> B 도시 간의 철도사업
 * A역 0번 B역 m번
 * 기차는 최대 n명 승차
 * 기차표 가격 = 출발역과 도착역 사이 정착역 개수 = 최대 m-1
 * 기차표 판매량 = 당 역에 도착하는 모든 예매 기차표
 * 최대 이익이 되는 주문량 선택하는 프로그램 작성.
 * 
 */

public class DFS연습_UVA301수송업 {
	static int from[],to[],people[];
	static int mx,station[],jumun,sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		from=new int[22];
		to=new int[22];
		people=new int[22];
		station=new int[8];
		int capacity, point;
		while(true) {
			capacity=sc.nextInt();
			point=sc.nextInt();
			jumun=sc.nextInt();
			if(capacity==0&&point==0&&jumun==0)
				break;
			mx=0;
			for(int i=0;i<point;i++) station[i]=capacity; // 역 최대인원 초기화.
			for(int i=0;i<jumun;i++) {
				from[i]=sc.nextInt();to[i]=sc.nextInt();people[i]=sc.nextInt();
			} // 각각의 역에서 주문되는 승객 정보들 입력.
			sum=0; // sum값 초기화.
			mx=0; // mx값 초기화.
			DFS(0); // DFS 시작.
			System.out.println(mx);
		}
	}
	static void DFS(int x) {
		if(x==jumun) { // 마지막 주문
			if(sum>mx) mx=sum; // 최대이익 갱신.
		}else {
			boolean check=false;
			// 처음에 이 주문을 선택할 수 있는지 확인.
			for(int i=from[x];i<to[x];i++) {
				if(station[i]<people[x]) // 한곳이라도 적다면...
					check=true;	// 이 거래는 실패일세...
			}
			if(!check) { // 가능하므로
				// 1. 이 주문을 선택한다.
				for(int i=from[x];i<to[x];i++) station[i]-=people[x];
				// 인간들 줄어라!
				sum+= people[x]*(to[x]-from[x]);
				// 이익금 늘어라!
				DFS(x+1); //다음으로
				for(int i=from[x];i<to[x];i++) station[i]+=people[x];
				sum-=people[x]*(to[x]-from[x]);
				// 돌아가라 원래대로.
			}
			DFS(x+1); // 이 주문을 선택하지 않았을 경우를 호출.			
		}	
	}
}
