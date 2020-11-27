package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10830_행렬제곱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		long B=Long.parseLong(st.nextToken());
		long [][]array=new long[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료.
		long[][] real = pow(array,B);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(real[i][j]%1000+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
//		 for (int i = 0; i < N; i++) {
//	            for (int j = 0; j < N; j++) {
//	                System.out.print((real[i][j]%1000)  + " ");
//	            }
//	            System.out.println("");
//	        }
		// 헤맨 부분 -> 마지막에 %1000을 해줘서 출력하지 않으면 틀리게 나오는 테케가 있음.
	}
	public static long[][] pow(long[][] arr,long num){
//		if(num==0) {
//			long [][]tmp=new long[arr.length][arr.length];
//			for(int i=0;i<arr.length;i++) {
//				for(int j=0;j<arr.length;j++) {
//						tmp[i][j]=1;
//				}
//			}
//			return tmp;
//		}
//		if(num==1) {
//			return arr;
//		}
//		if(num%2==0) {
//			long[][] tmp=pow(arr,num/2);
//			return result(tmp,tmp);
//		}else {
//			long[][]tmp=pow(arr,num-1);
//			return result(arr,tmp);
//		} 해맨 부분 -> tmp로 pow를 계산해서 저장하지 않고 직접 때려넣으면 이중으로 계산이 되게 된다.
		long b=num;
		int n=arr.length;
		if (b == 0) {
            long[][] tmp = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = 1;
                }
            }
            return tmp;
        }
        if (b == 1)
            return arr;
        if (b % 2 == 1) {
            //홀수
            long[][] tmp = pow(arr, b - 1);
            return result(arr, tmp);
        } else {
            //짝수
            long[][] tmp = pow(arr, b / 2);
            return result(tmp, tmp);
        }
	}
	public static long[][] result(long [][]array,long[][]array2){
//		int size=array.length;
//		long[][] narray=new long[size][size]; 
//		for(int i=0;i<size;i++) {
//			for(int j=0;j<size;j++) {
//				for(int k=0;k<size;k++) {
//					narray[i][j]+=array[i][k]*array2[k][j];
//				}
//				narray[i][j]%=1000;
//			}
//		}
//		return narray;
		int n=array.length;
		long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long tmp = 0;
                for (int k = 0; k < n; k++) {
                    tmp += array[i][k] * array2[k][j];
                }
                result[i][j] = tmp % 1000;
            }
        }
        return result;
	}
	
}
