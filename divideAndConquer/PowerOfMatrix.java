package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PowerOfMatrix {

	// 10830��	2021.01.12.
	
	/*
	 * ó���� �ð��ʰ��� ������ �ι�°�� �����ʾҴ�!
	 * �ٺ����� int[][] re = pow(result, m/2);�� �ѹ��� �ص� �Ǵµ�
	 * arr1, arr2�� �����ϸ鼭 �� ������ �ι� �ߴ�. �׷��� �ð��ʰ��� �� �� �ۿ�!
	 * �װ͸� ���ƴ��� �ٷ� Ǯ�ȴ�!
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
				bw.write(result[i][j]%1000+"");	//2 1 1000 1000 1000 1000 �� ���� �Է��� ���ϱ����� 1000
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
