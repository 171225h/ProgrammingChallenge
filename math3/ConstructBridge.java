package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConstructBridge {
	
	//	1010��	2021.01.08.

	/*
	 * ��� ���� �� �� ���Ҵµ�...
	 * ����л��� ���� Ǯ� ���չ���.
	 * n�� m�� ���� ��, �� ū ���� m�̶��
	 * mCn�� �Ͽ� ���� ���� ������.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		int[][] dp = new int[31][31];
		int n, m;
		StringTokenizer st = null;


		for(int i = 1; i<=30; i++) {
			for(int j = 0; j<=i; j++) {
				if(j==0 || i==j)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}

		for(int i = 0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			bw.write(dp[m][n]+"");
			
			if(i<testCase-1)
				bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
