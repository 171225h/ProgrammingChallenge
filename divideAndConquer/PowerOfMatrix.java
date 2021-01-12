package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PowerOfMatrix {

	// 10830번	2021.01.12.
	
	/*
	 * 처음엔 시간초과가 났지만 두번째는 나지않았다!
	 * 바보같이 int[][] re = pow(result, m/2);는 한번만 해도 되는데
	 * arr1, arr2에 저장하면서 위 실행을 두번 했다. 그러니 시간초과가 날 수 밖에!
	 * 그것만 고쳤더니 바로 풀렸다!
	 */
	
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		arr = new int[n][n];

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int[][] result = pow(arr, m);

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				bw.write(result[i][j]%1000+"");	//2 1 1000 1000 1000 1000 과 같은 입력을 피하기위해 1000
				if(j<n-1)
					bw.write(" ");
			}
			if(i<n-1)
				bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	public static int[][] pow(int[][] result, long m) {
		if(m==1) {
			return result;
		}

		int[][] re = pow(result, m/2);
		
		re = matrixMultiplication(re, re);
		if(m%2==0) {
			return re;
		}
		else {
			return matrixMultiplication(arr, re);
		}			

	}

	private static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {

		int[][] result = new int[n][n];

		for(int i = 0; i<n; i++)
			for(int j = 0; j<n; j++) {
				for(int p = 0; p<n; p++)
					result[i][j]+=(arr1[i][p]%1000*arr2[p][j]%1000)%1000;
				result[i][j]=result[i][j]%1000;
			}
		return result;
	}

}
