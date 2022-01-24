package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOIOI {

	/*
	 * 2022.01.24.
	 * 5525��
	 * fail
	 * 
	 * ó���� �κ������̾���
	 * for���� ���鼭 IOI�� ������ ���ϴ� ������ ������
	 * �׷��� DP�� �̿��Ͽ� O(m)���� Ǯ �� �ִٴ� ���� ���� ���� �˾���
	 * ����ϴ�...
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int[] dp = new int[m];
		int result = 0;

		for(int i = 0; i < m-1; i++) {
			if(s.subSequence(i, i+2).equals("OI")) {
				if(i-2>=0) 
					dp[i] = dp[i-2] + 1;
				else
					dp[i]=1;

				
				if(dp[i] >= n && i - 2*n + 1>= 0 && s.charAt(i - 2*n + 1)=='I')
					result++;

			}
		}

		bw.write(result+"");
		bw.flush();
		bw.close();

	}

}
