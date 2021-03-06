package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StairClimbing {

	// 2579�� 	2021.02.25.
	
	/*
	 * ���θ��ñ� ������ �ܷ��� ����!!
	 * 
	 * n��° ����� ��� ��츦 ��������
	 * 
	 * 1. �� ��� �Ѿ ��� ���
	 * 	n-3	n-2	n-1	n
	 * 	o	o	x	o	// n-3��° ��ܿ� ������� n-2�� ������ ��
	 *  x	o	x	o
	 *  
	 * 2. �� ��� �Ѿ ��� ���
	 * 	n-3	n-2	n-1	n
	 * 	o	x	o	o	
	 *  x	x	o	o	// �ִ��� ���� ����� ��� ���� ��ǥ�� ������ �� ���� Ż��
	 *  
	 *  ����, dp[i]�� arr[i]+dp[i-2]�� arr[i]+arr[i-1]+dp[i-3]�� ū ���� ���� ��!
	 *  
	 *  ����� ������ ����� ��� ��츦 ����ؾ� �ϴ�
	 *  dp[n-1]�� ����ؾ���!
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		if(n>0) {
			dp[0]=arr[0];
		}
		if(n>1) {
			dp[1]=arr[0]+arr[1];
		}
		if(n>2) {
			dp[2]=arr[2]+Math.max(arr[0], arr[1]);
		}
		
		for(int i = 3; i<n; i++) {
			dp[i]=arr[i]+Math.max(dp[i-2], dp[i-3]+arr[i-1]);
		}
		
		bw.write(dp[n-1]+"");
		bw.flush();
		bw.close();
	}

}
