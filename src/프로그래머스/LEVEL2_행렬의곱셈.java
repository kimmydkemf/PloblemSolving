package 프로그래머스;

public class LEVEL2_행렬의곱셈 {
	class Solution {
	    public int[][] solution(int[][] arr1, int[][] arr2) {
	        int[][] answer = {};
	        int arr1r=arr1.length;
	        int arr1c=arr1[0].length;
	        int arr2r=arr2[0].length;
	        answer = new int[arr1r][arr2r];
	        for(int i=0;i<arr1r;i++){
	            for(int j=0;j<arr2r;j++){
	                for(int k=0;k<arr1c;k++){
	                   answer[i][j]+=arr1[i][k]*arr2[k][j]; 
	                }
	            }
	        }
	        return answer;
	    }
	}
}
