package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의정렬_BJ10825_국영수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		Student [] arr=new Student[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i]=new Student(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			sb.append(arr[i].name+"\n");
		}
		System.out.println(sb.toString());
	}
	static class Student implements Comparable<Student>{
		int korean,english,math;
		String name;
		Student(String str,int k,int e, int m){
			name=str;
			korean=k;
			english=e;
			math=m;
		}
		@Override
		public int compareTo(Student o) {
			if(o.korean==this.korean) {
				if(this.english==o.english) {
					if(o.math==this.math) {
						return this.name.compareTo(o.name);
					}
					return o.math-this.math;
				}
				return this.english-o.english;
			}
			return o.korean-this.korean;
		}
		
	}
}
