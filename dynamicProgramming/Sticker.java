package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
	
	// 9465번 2021.08.06.
	
	/*
	 * 5달 전에 풀지 못한 DP문제를 드디어 풀었다 ㅜ.ㅠ 감동실화
	 * 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int n = 0;
		int[][] sticker = null;
		int[][] dp = null;
		int count = 0;
		
		for(int i = 0; i<testCase; i++) {
			n = Integer.parseInt(br.readLine());
			sticker = new int[2][n];
			dp = new int[2][n];
			
			count = 0;
			
			for(int j = 0; j<2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<n; k++) 
					sticker[j][k] = Integer.parseInt(st.nextToken());
			}
			
			//showSticker(sticker);
				
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			
			
			if(n>1) {
				dp[0][1] = dp[1][0]+sticker[0][1];
				dp[1][1] = dp[0][0]+sticker[1][1];
			}
			
			for(int j = 2; j<n; j++) {
				dp[0][j] = sticker[0][j] + Math.max(dp[0][j-2], Math.max(dp[1][j-2], dp[1][j-1]));
				dp[1][j] = sticker[1][j] + Math.max(dp[0][j-2], Math.max(dp[1][j-2], dp[0][j-1]));
			}
			
			for(int j = 0; j<2; j++) {
				for(int k = 0; k<sticker[0].length; k++) 
					count = Math.max(count, dp[j][k]);
			}
			
			sb.append(count+"\n");
			
		}
		
		sb.delete(sb.length()-1, sb.length());
		System.out.print(sb.toString());
	}

	private static void showSticker(int[][] sticker) {
		
		for(int j = 0; j<2; j++) {
			for(int k = 0; k<sticker[0].length; k++) 
				System.out.print(sticker[j][k]+" ");
			System.out.println();
		}

	}

}
