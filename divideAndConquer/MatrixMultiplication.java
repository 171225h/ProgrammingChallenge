package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixMultiplication {
	
	// 2740¹ø	2021.01.08.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, m, k;
		int[][] matrix1, matrix2, result;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix1 = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				matrix1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		matrix2 = new int[m][k];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<k; j++) {
				matrix2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[n][k];
		for(int i = 0; i<n; i++)
			for(int j = 0; j<k; j++)
				for(int p = 0; p<m; p++)
					result[i][j]+=matrix1[i][p]*matrix2[p][j];

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<k; j++) {
				bw.write(result[i][j]+"");
				if(j<k-1)
					bw.write(" ");
			}
			if(i<n-1)
				bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
