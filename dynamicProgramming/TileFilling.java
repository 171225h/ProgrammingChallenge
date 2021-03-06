package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TileFilling {
	
	// 2133번 	2021.03.06.
	
	/*
	 * 내가 dp를 푸는 방식은
	 * n=1일때, 2, 3, ...을 보고
	 * n-1, n-2 값을 토대로 n 값을 유추하는 형식이었으나
	 * 이 문제는 이것이 통하지 않는 문제였다.
	 * 
	 * 위의 방법 말고 다른 방법이 있을 수 있다는 것을 아주 잘 알려준 문제
	 */

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];

		dp[0]=1;
		if(n+1>2)
			dp[2]=3;

		for(int i = 4; i<=n; i++) {
			if(i%2==1)
				continue;

			dp[i]=dp[i-2]*3;

			for (int j = 4; j <= i; j += 2)
				dp[i] += dp[i-j]*2;
		}

		bw.write(dp[n]+"");
		bw.flush();
		bw.close();
	}

}
