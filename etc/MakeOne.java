package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeOne {

	// 1463번	2021.01.06.
	/*
	 * 시간초과로 재채점 됨.
	 * Dynamic Programming은 점화식을 만들고
	 * 그 점화식은 0, 1과 같은 밑에서부터 채워나가는 것을 목표로 만들기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n+1];

		int temp = 0;
		for(int i = 2; i<=n; i++) {
			temp = dp[i-1]+1;
			
			if(i%2==0)
				temp = Math.min(temp, dp[i/2]+1);
			
			if(i%3==0)
				temp = Math.min(temp, dp[i/3]+1);
			
			dp[i]=temp;
		}

		bw.write(dp[n]+"\n");
		bw.flush();
		bw.close();
	}

}
