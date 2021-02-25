package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LargestIncreasingSubsequence {

	// 11053번 	2021.02.24.
	
	/*
	 * 예전에 풀어본 문젠데 또 못풀었다..
	 * 
	 * Dynamic Programming
	 * 모든 작은 문제들은 한번만 풀어야 한다. 따라서 정답을 구한 작은 문제를 어디에 메모해 놓고,
	 * 다시 그보다 큰 문제를 풀어나갈 때 작은 문제가 나타나면 메모한 것을 사용한다.
	 * 
	 * DP는 뒤도 돌아보지않고 단 한번만 계산해야된다는 강박이 있었는데
	 * 이 문제를 보니 계산해놓은 것은 여러번봐도 괜찮았다는 것이 생각이 났다.
	 * 
	 * DP는 현재의 값을 단 한번에 계산해야되는 것이지 전에 계산해 놓은 것을 한번만 보라는 게 아니라는 것을
	 * 이 문제를 통해 다시 배울수있었다!
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
