package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling {

	// 11726�� 	2021.02.19.
	
	/*
	 * ���� DP����!
	 * dp[i]=dp[i-1]+dp[i-2]�� ã�Ƴ��ٸ� �ٷ� Ǯ���ִ�
	 * ������ n�� 1���� 6���� �����̸� ��Ģ�� �߰��ߴ�
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
