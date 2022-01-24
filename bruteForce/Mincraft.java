package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Mincraft {

	/*
	 * 2022.01.24.
	 * 18111번
	 * 
	 * 어떻게하면 빠르게 풀 수 있을까 고민했는데
	 * 엊그제 푼 문제처럼 brute force로도 풀 수 있지 않을까 해서 도전!
	 * 햇더니 정답이었다 ㅇ0ㅇ
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 제거 2초, 놓기 1초
		int time = Integer.MAX_VALUE;
		int hight = 0;
		int temp = 0;
		
		// 시간이 같으면 높은 순으로 출력하자고 함
		for(int i = 256; i>-1; i--) {
			// i 높이로 가능한지 확인한다.
			temp = check(arr, i, b);
			
			if(temp >= 0 && time > temp) {
				time = temp;
				hight = i;
			}
		}
		
		// 출력
		bw.write(time + " " + hight+"");
		bw.flush();
		bw.close();
		
	}

	/**
	 * h만큼의 높이로 가능한지 확인하는 메소드.
	 * 
	 * @param arr	땅 높이가 들어있는 arr
	 * @param h		만들 높이
	 * @param block	현재 소지하고있는 블럭 수
	 * @return 가능하지 않으면 -1, 가능하면 소요 시간을 반환
	 */
	private static int check(int[][] arr, int h, int block) {
		
		int time = 0;
		int temp = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j<arr[0].length; j++) {
				
				if(arr[i][j] > h) {
					temp = arr[i][j] - h;	// 블럭 제거
					block += temp;
					time = time + temp*2;
					
				}
				else if(arr[i][j] < h) {// 블럭 더하기
					temp = h - arr[i][j];
					block -= temp;
					time = time + temp;
				}
				
			}
		}
		
		if(block < 0)
			return -1;
		else
			return time;
	}
	

}
