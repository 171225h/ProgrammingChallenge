package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuadTree {
	
	// 1992번	2020.12.29.
	
	/*
	 * 2630을 조금만 변형하면 바로 풀 수 있었다.
	 */

	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		String s = null;

		arr = new int[n][n];

		for(int i = 0; i<n; i++) {
			s = br.readLine();
			for(int j = 0; j<n; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}

		//제일 중요한 부분!
		divideAndConquer(0, 0, n);

		// output
		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
	}

	public static void divideAndConquer(int i, int j, int n) {
		if(n<1)
			return;

		if(promising(i,j,n)) {
			sb.append(arr[i][j]+"");
		}
		else {	// 4개로 나눠지면 괄호를 써준다!
			sb.append("(");
			for(int x = i; x<i+n; x+=n/2) {
				for(int y = j; y<j+n; y+=n/2)
					divideAndConquer(x, y, n/2);
			}
			sb.append(")");
		}

	}


	private static boolean promising(int x, int y, int k) {
		int startColor = arr[x][y];

		for(int i = x; i<x+k; i++) {
			for(int j = y; j<y+k; j++) {
				if(arr[i][j]!=startColor)
					return false;
			}
		}

		return true;
	}

}
