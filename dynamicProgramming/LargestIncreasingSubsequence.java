package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LargestIncreasingSubsequence {

	// 11053�� 	2021.02.24.
	
	/*
	 * ������ Ǯ� ������ �� ��Ǯ����..
	 * 
	 * Dynamic Programming
	 * ��� ���� �������� �ѹ��� Ǯ��� �Ѵ�. ���� ������ ���� ���� ������ ��� �޸��� ����,
	 * �ٽ� �׺��� ū ������ Ǯ��� �� ���� ������ ��Ÿ���� �޸��� ���� ����Ѵ�.
	 * 
	 * DP�� �ڵ� ���ƺ����ʰ� �� �ѹ��� ����ؾߵȴٴ� ������ �־��µ�
	 * �� ������ ���� ����س��� ���� ���������� �����Ҵٴ� ���� ������ ����.
	 * 
	 * DP�� ������ ���� �� �ѹ��� ����ؾߵǴ� ������ ���� ����� ���� ���� �ѹ��� ����� �� �ƴ϶�� ����
	 * �� ������ ���� �ٽ� �����־���!
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

		for(int i = 0; i<n; i++) {
			dp[i]=1;
			for(int j = 0; j<i; j++) {
				if(arr[j]<arr[i])
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
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
