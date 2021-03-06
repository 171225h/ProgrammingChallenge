package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ContinuousSum {

	// 1912�� 	2021.02.25.
	
	/*
	 * dp���� i��° ���� ������ ��츦 �����Ѵ�.
	 * �̶� i��°���� �����ϴ� ����� ���� �ΰ��� �ȴ�
	 * 1. i-1��° dp���� �ڽ��� ������ ���
	 * 2. i-1��° dp���� �������� �ʰ� �ڽŸ� ������ ���
	 * 
	 * ������ i+1 dp���� i���� ������ ���ԵǾ� ������ ��� ���� �� �ִ�!
	 * 
	 * 1�� 2��� �� ū ���� dp�� �������ָ� �ȴ�.
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			arr[i]=Integer.parseInt(st.nextToken());

		dp[0]=arr[0];

		for(int i = 1; i<n; i++) {
			if(arr[i]+dp[i-1]>arr[i])
				dp[i]=dp[i-1]+arr[i];
			else
				dp[i]=arr[i];
		}


		int result = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++) {
			if(result<dp[i])
				result=dp[i];
		}

		bw.write(result+"");
		bw.flush();
		bw.close();

	}

}
