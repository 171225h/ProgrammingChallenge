package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOIOI {

	/*
	 * 2022.01.24.
	 * 5525번
	 * fail
	 * 
	 * 처음에 부분정답이었음
	 * for문을 돌면서 IOI와 같은지 비교하는 식으로 진행함
	 * 그러나 DP를 이용하여 O(m)으로 풀 수 있다는 것을 답을 보고 알았음
	 * 대단하당...
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
