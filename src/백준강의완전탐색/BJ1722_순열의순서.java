package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1722_순열의순서 {
	static int[] arr;
	static long[] fact;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		fact=new long[21];
		check=new boolean[21];
		fact[0]=1;
		for(int i=1;i<=20;i++)
			fact[i]=fact[i-1]*i;
		StringTokenizer st=new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken());
		if(K==1) {
			long t=Long.parseLong(st.nextToken());
			for(int i=0;i<N;i++) {
				for(int j=1;j<=N;j++) {
					if(check[j])
						continue;
					if(t>fact[N-1-i]) {
						t-=fact[N-1-i];
					}else {
						arr[i]=j;
						check[j]=true;
						break;
					}
				}
			}
			for(int i=0;i<N;i++)
				System.out.print(arr[i]+" ");
		}else {
			int[]brr=new int[N];
			for(int i=0;i<N;i++)
				brr[i]=Integer.parseInt(st.nextToken());
			long ans=1;
			for(int i=0;i<N;i++) {
				int now=brr[i];
				int cnt=0;
				for(int j=1;j<now;j++) {
					if(check[j])
						continue;
					else
						ans+=fact[N-i-1];
				}
				check[now]=true;
			}
			System.out.println(ans);
		}
//		Scanner scan = new Scanner(System.in);
//        long [] f = new long[21];
//        boolean [] c = new boolean[21]; //n엔 중복된 수가 없으므로 중복을 없앨 boolean 배열
//        Arrays.fill(f, 1);
//        
//        for(int i=1; i<=20; i++) { //팩토리얼 구하기
//            f[i] = f[i-1]*i;
//        }
//        
//        int n = scan.nextInt();
//        int what = scan.nextInt();
//        
//        int [] a = new int[n];
//        if(what == 2) { //몇 번째 순열인지
//            for(int i=0; i<n; i++)
//                a[i] = scan.nextInt();
//            
//            long ans = 1; //순열은 1 번째 부터 시작
//            for(int i=0; i<n; i++) {
//                for(int j=1; j<a[i]; j++) {
//                    if(!c[j])
//                        ans += f[n-i-1];
//                }
//                c[a[i]]=true;
//            }
//            System.out.println(ans);
//        }
//        else if(what == 1) { //k 번째 순열 출력
//            long k = scan.nextLong();
//            for(int i=0; i<n; i++) {
//                for(int j=1; j<=n; j++) {
//                    if(c[j])
//                        continue;
//                    if(f[n-i-1] < k) {
//                        k -= f[n-i-1];
//                    }
//                    else {
//                        a[i] = j;
//                        c[j] = true;
//                        break;
//                    }
//                }
//            }
//            for(int i=0; i<n; i++) {
//                System.out.print(a[i] + " ");
//            }
//        }
	}
}
