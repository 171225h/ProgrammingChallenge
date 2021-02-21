package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IncreasingNumber {

	// 11057�� 	2021.02.21.
	
	/*
	 * 1 1 1 1 ... 1
	 * 1 2 3 4 ... 10
	 * 1 3 6 10 ... 55
	 * 
	 * ���� ���� ������ �����̴� ���� �˾Ҵ�.
	 * n=1�϶�, ���� 10	n=0�϶� ���� ��� ���� ��
	 * n=2�϶�, ���� 55	n=1�϶� ���� ��� ���� ��
	 * n=3�϶�, ���� 220	n=2�϶� ���� ��� ���� ���̴�.
	 * 
	 * ��, arr[i]�� ���� ���� arr[i-1]�� ������ arr[i]�� ���� ��ģ ���̶� ��Ģ�� ������.
	 * 
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int mod = 10007;
		int[] arr = new int[10];
		
		for(int i = 0; i<10; i++)	// �ϴ� default�� 1�� ä���ش�.
			arr[i]=1;
		
		int sum = 0;
		for(int i = 0; i<n; i++) {	
			sum = 1;					// �Ʒ� for���� 1���� �����ϴ� �ϴ� 1���� �ִ´�.	
			for(int j = 1; j<10; j++) {	
				
				sum = (sum+arr[j])%mod;	// arr[9]�ǰ��� ������� sum
				
				if(j==9)
					arr[j]=sum;
				else 
					arr[j] = (arr[j]+arr[j-1])%mod;
				
			}
		}
		
		bw.write(arr[9]+"");
		bw.flush();
		bw.close();
	}

}
