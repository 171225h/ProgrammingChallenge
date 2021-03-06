package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TileFilling {
	
	// 2133�� 	2021.03.06.
	
	/*
	 * ���� dp�� Ǫ�� �����
	 * n=1�϶�, 2, 3, ...�� ����
	 * n-1, n-2 ���� ���� n ���� �����ϴ� �����̾�����
	 * �� ������ �̰��� ������ �ʴ� ��������.
	 * 
	 * ���� ��� ���� �ٸ� ����� ���� �� �ִٴ� ���� ���� �� �˷��� ����
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
