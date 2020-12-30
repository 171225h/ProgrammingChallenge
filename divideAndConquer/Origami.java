package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Origami {
	
	// 2630번	2020.12.29.
	/*
	 * 먼저 promising인지 확인하고!
	 * 아니면 다시 재귀로
	 * 만약 k가 1이면 더이상 재귀 호출 x
	 */
	
	static int white;
	static int blue;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		white = 0;
		blue = 0;
		arr = new int[n][n];
		
		StringTokenizer st = null;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		divideAndConquer(0, 0, n);
		
		bw.write(white+"\n");
		bw.write(blue+"");
		bw.flush();
		bw.close();
	}

	public static void divideAndConquer(int i, int j, int k) {
		if(!promising(i,j,k)) {
			if(k==1)
				return;
			else {
				for(int x = i; x<i+k; x+=k/2) {
					for(int y = j; y<j+k; y+=k/2) {
						divideAndConquer(x, y, k/2);
					}
				}
			}
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
		
		if(startColor==0)
			white++;
		else
			blue++;
		
		return true;
	}

}
