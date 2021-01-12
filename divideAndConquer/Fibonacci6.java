package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fibonacci6 {

	// 11444번	2021.01.12.
	
	/*
	 * 행렬 제곱을 응용해서 푸는 문제!
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long[][] arr = {{1, 1},{1, 0}};
	
		if(n==0)
			bw.write(0+"");
		else if(n<3)
			bw.write(1+"");
		else {
			arr = pow(arr, n);
			bw.write(arr[0][1]%1000000007+"");
		}

		bw.flush();
		bw.close();
	}

	public static long[][] pow(long[][] result, long m) {
		if(m==1) {
			return result;
		}

		long[][] arr = {{1, 1},{1, 0}};
		long[][] re = pow(result, m/2);
		
		re = matrixMultiplication(re, re);
		if(m%2==0) {
			return re;
		}
		else {
			return matrixMultiplication(arr, re);
		}			

	}

	private static long[][] matrixMultiplication(long[][] arr1, long[][] arr2) {

		long[][] result = new long[2][2];

		for(int i = 0; i<2; i++)
			for(int j = 0; j<2; j++) {
				for(int p = 0; p<2; p++)
					result[i][j]+=(arr1[i][p]%1000000007*arr2[p][j]%1000000007)%1000000007;
				result[i][j]=result[i][j]%1000000007;
			}
		return result;
	}

}
