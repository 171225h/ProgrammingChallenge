package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LongestDecreasingSubSequence {

	// 11722�� 	2021.02.24.
	
	/*
	 * ���� �� �����ϴ� ������
	 * 0���Ͱ� �ƴ� n-1���� �����Ѵٰ� �����ϸ� ����.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			arr[i]=Integer.parseInt(st.nextToken());

		for(int i = n-1; i>-1; i--) {
			dp[i]=1;

			for(int j = n-1; j>i; j--) {
				if(arr[j]<arr[i])
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
		}

		int result = 0;
		for(int i = 0; i<n; i++)
			if(result<dp[i])
				result=dp[i];

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
