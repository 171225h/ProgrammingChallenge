package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LANcable {

	// 1654��	2021.01.14.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());	// ������ k���� ����
		int n = Integer.parseInt(st.nextToken());	// n���� ������
		
		int[] lans = new int[k];	// ������ ���� ���� ����
		
		for(int i = 0; i<k; i++) 
			lans[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(lans);
		
		long left = 1;					// ������ ���̴� 1����
		long right = lans[k-1];			// ���� �� ���̱���!
		long median = (right+left)/2;
		long length = 1;
		long result = -1;
		int count = 0;					// length�� ��� cable�� ���� �� �ִ���
		
		while(left<=right) {		
			count = 0;
			length = median;
			for(int i = 0; i<k; i++) {
				count+=lans[i]/length;
			}
			
			
			if(count<n) {	// n����ŭ �������ϴµ� n������ ���ڸ��� �� ���̰� ª�ƾ� ��
				right=median-1;
				median = (right+left)/2;
			}
			else {			// �װ� �ƴ϶�� �� �� ���̰� ���� �� ������ ���̸� �� ����ؼ�!
				left=median+1;
				median = (right+left)/2;
				result = length;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	
	}

}
