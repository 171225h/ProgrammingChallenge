package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WoodCutting {
	
	// 2805��	2021.01.14.
	
	/*
	 * ó���� Ǯ ����, count, temp, result�� int������ ����� Ǯ����
	 * �׷����� �ð��ʰ��� ����.
	 * ����ȯ �ʿ��� �����ϱ�? �ϰ� ���� �͵��� �� long���� �ٲپ����� �ٷ� Ǯ�ȴ�.
	 * 
	 * ������ Ǯ�� �����غ���...
	 * ����ȯ������ �ð��� �����ɸ� ���� �ƴ϶�
	 * while�� �ȿ��� ������ ���� �κп��� int���� �� ū ���� ���� ��
	 * overflow�� ���� ������ ���� �� ����
	 * �ð��ʰ��� bigO�� �ƴ� �����ε� �� �� �ִٴ� ���� �����.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// ���� ��
		int m = Integer.parseInt(st.nextToken());	// ������ ���� ��

		int[] woods = new int[n];
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			woods[i]=Integer.parseInt(st.nextToken());
		
		long left = 0;
		long right = 2000000000;
		long median = (left+right)/2;
		
		long count = 0;
		long temp = 0;
		long result = 0;
		
		while(left<=median) {
			count = 0;
			
			for(int i = 0; i<n; i++) {
				temp = woods[i]-median;
				if(temp>0)
					count+=temp;
			}
			
			if(count<m) {
				right = median-1;
				median = (left+right)/2;
			}
			else {
				result = median;
				left = median+1;
				median = (left+right)/2;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
