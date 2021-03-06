package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ContinuousSum {

	// 1912번 	2021.02.25.
	
	/*
	 * dp에는 i번째 수를 포함한 경우를 저장한다.
	 * 이때 i번째수를 포함하는 경우의 수는 두개가 된다
	 * 1. i-1번째 dp값과 자신을 포함한 경우
	 * 2. i-1번째 dp값을 포함하지 않고 자신만 포함한 경우
	 * 
	 * 어차피 i+1 dp값은 i값이 무조건 포함되어 있으니 계속 비교할 수 있다!
	 * 
	 * 1과 2경우 중 큰 수를 dp에 저장해주면 된다.
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			arr[i]=Integer.parseInt(st.nextToken());

		dp[0]=arr[0];

		for(int i = 1; i<n; i++) {
			if(arr[i]+dp[i-1]>arr[i])
				dp[i]=dp[i-1]+arr[i];
			else
				dp[i]=arr[i];
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
