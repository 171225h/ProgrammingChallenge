package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StairClimbing {

	// 2579번 	2021.02.25.
	
	/*
	 * 와인마시기 문제로 단련한 문제!!
	 * 
	 * n번째 계단을 밟는 경우를 생각하자
	 * 
	 * 1. 두 계단 넘어서 밟는 경우
	 * 	n-3	n-2	n-1	n
	 * 	o	o	x	o	// n-3번째 계단에 상관없이 n-2만 밟으면 됨
	 *  x	o	x	o
	 *  
	 * 2. 한 계단 넘어서 밟는 경우
	 * 	n-3	n-2	n-1	n
	 * 	o	x	o	o	
	 *  x	x	o	o	// 최대한 많은 계단을 밟는 것이 목표기 때문에 이 경우는 탈락
	 *  
	 *  따라서, dp[i]는 arr[i]+dp[i-2]와 arr[i]+arr[i-1]+dp[i-3]중 큰 것을 고르면 됨!
	 *  
	 *  결과는 마지막 계단을 밟는 경우를 출력해야 하니
	 *  dp[n-1]을 출력해야함!
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		if(n>0) {
			dp[0]=arr[0];
		}
		if(n>1) {
			dp[1]=arr[0]+arr[1];
		}
		if(n>2) {
			dp[2]=arr[2]+Math.max(arr[0], arr[1]);
		}
		
		for(int i = 3; i<n; i++) {
			dp[i]=arr[i]+Math.max(dp[i-2], dp[i-3]+arr[i-1]);
		}
		
		bw.write(dp[n-1]+"");
		bw.flush();
		bw.close();
	}

}
