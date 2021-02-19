package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling {

	// 11726번 	2021.02.19.
	
	/*
	 * 쉬운 DP문제!
	 * dp[i]=dp[i-1]+dp[i-2]만 찾아낸다면 바로 풀수있다
	 * 손으로 n은 1부터 6까지 끄적이며 규칙을 발견했다
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int mod = 10007;
		int[] dp = new int[n+1];
		
		for(int i = 1; i<=3 && i<n+1; i++)
			dp[i]=i;
		
		for(int i = 4; i<n+1; i++)
			dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
		
		bw.write(dp[n]+"");
		bw.flush();
		bw.close();
	}

}
