package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling2 {

	//11727번 	2021.02.19.
	
	/*
	 * 규칙을 찾으려고 사각형 그리다가 잘 안보여서
	 * 한번 더 셌다..
	 * n이 짝수일때랑 홀수일때의 규칙이 다를 수도 있다는 것을
	 * 알 수 있던 문제!
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int mod = 10007;
		int[] dp = new int[n+1];
		
		dp[1]=1;
		if(n>1)
			dp[2]=3;

		for(int i = 3; i<n+1; i++) {
			if(i%2==0)
				dp[i]=(dp[i-1]*2+1)%mod;
			else
				dp[i]=(dp[i-1]*2-1)%mod;
		}
		
		bw.write(dp[n]+"");
		bw.flush();
		bw.close();
	}

}
