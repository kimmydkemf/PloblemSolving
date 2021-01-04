package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1525_퍼즐 {
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int start=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int temp=sc.nextInt();
				if(temp==0) temp=9;
				start=start*10+temp;
			}
		}
		Queue<Integer> queue=new LinkedList<>();
		HashMap<Integer,Integer> d=new HashMap<>();
		queue.add(start);
		d.put(start,0);
		while(!queue.isEmpty()) {
			int now=queue.poll();
			String s=Integer.toString(now);
			int z=s.indexOf('9');
			int x=z/3;
			int y=z%3;
			for(int k=0;k<4;k++) {
				int nx=x+di[k];
				int ny=y+dj[k];
				StringBuilder ts=new StringBuilder(s);
				if(nx>=0&&nx<3&&ny>=0&&ny<3) {
					char temp=ts.charAt(nx*3+ny);
					ts.setCharAt(z,temp);
					ts.setCharAt(nx*3+ny,'9');
					int next=Integer.parseInt(ts.toString());
					if(!d.keySet().contains(next)) {
						d.put(next,d.get(now)+1);
						queue.add(next);
					}
				}
			}
		}
		if(d.keySet().contains(123456789)) {
			System.out.println(d.get(123456789));
		}else {
			System.out.println(-1);
		}
	}
}
