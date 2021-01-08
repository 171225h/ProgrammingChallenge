package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConstructBridge {
	
	//	1010번	2021.01.08.

	/*
	 * 어디서 많이 본 것 같았는데...
	 * 고등학생때 많이 풀어본 조합문제.
	 * n과 m이 들어올 때, 더 큰 수가 m이라면
	 * mCn을 하여 답을 내는 문제다.
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
