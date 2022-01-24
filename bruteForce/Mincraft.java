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
	 * 18111��
	 * 
	 * ����ϸ� ������ Ǯ �� ������ ����ߴµ�
	 * ������ Ǭ ����ó�� brute force�ε� Ǯ �� ���� ������ �ؼ� ����!
	 * �޴��� �����̾��� ��0��
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
		
		// ���� 2��, ���� 1��
		int time = Integer.MAX_VALUE;
		int hight = 0;
		int temp = 0;
		
		// �ð��� ������ ���� ������ ������ڰ� ��
		for(int i = 256; i>-1; i--) {
			// i ���̷� �������� Ȯ���Ѵ�.
			temp = check(arr, i, b);
			
			if(temp >= 0 && time > temp) {
				time = temp;
				hight = i;
			}
		}
		
		// ���
		bw.write(time + " " + hight+"");
		bw.flush();
		bw.close();
		
	}

	/**
	 * h��ŭ�� ���̷� �������� Ȯ���ϴ� �޼ҵ�.
	 * 
	 * @param arr	�� ���̰� ����ִ� arr
	 * @param h		���� ����
	 * @param block	���� �����ϰ��ִ� �� ��
	 * @return �������� ������ -1, �����ϸ� �ҿ� �ð��� ��ȯ
	 */
	private static int check(int[][] arr, int h, int block) {
		
		int time = 0;
		int temp = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j<arr[0].length; j++) {
				
				if(arr[i][j] > h) {
					temp = arr[i][j] - h;	// �� ����
					block += temp;
					time = time + temp*2;
					
				}
				else if(arr[i][j] < h) {// �� ���ϱ�
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
