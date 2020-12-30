package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CountOfPaper {
	
	// 1780번	2020.12.30.
	/*
	 * 쿼드트리 응용 /4를 /9로 바꿔준다
	 */
	
	static int[][] arr;
	static int minus;
	static int zero;
	static int plus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		minus = 0;				// -1 갯수
		zero = 0;				// 0 갯수
		plus = 0;				// 1 갯수
		arr = new int[n][n];	// 종이를 받을 arr
		
		StringTokenizer st = null;
		
		//input
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		divideAndConquer(0, 0, n);
		
		//output
		bw.write(minus+"\n");
		bw.write(zero+"\n");
		bw.write(plus+"");
		bw.flush();
		bw.close();
		
	}

	public static void divideAndConquer(int i, int j, int n) {
		
		if(!isPromising(i, j, n)) {
			for(int x = i; x<i+n; x+=n/3) {
				for(int y =j; y<j+n; y+=n/3) {
					divideAndConquer(x, y, n/3);
				}
			}
		}
	}

	private static boolean isPromising(int i, int j, int n) {
		
		int startNum = arr[i][j];
		
		for(int x = i; x<i+n; x++) {
			for(int y = j; y<j+n; y++) {
				if(startNum!=arr[x][y])
					return false;
			}
		}
		
		if(startNum<0)
			minus++;
		else if(startNum==0)
			zero++;
		else if(startNum>0)
			plus++;
		
		return true;
	}

}
