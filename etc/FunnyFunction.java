package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FunnyFunction {

	// 9184번	2021.01.06.
	/*
	 * 21*21*21이라 3중 for문으로도 풀린 것 같다.
	 * 풀고나서 다른사람들이 푼 것을 보니 재귀를 사용한 메모이제이션으로 풀었다.
	 * 보고나니 저게 더 좋아보인다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int[][][] dp = new int[21][21][21];
		
		for(int i = 0; i<21; i++) {
			for(int j = 0; j<21; j++) {
				for(int k = 0; k<21; k++) {
					if(i==0 || j==0 || k==0)
						dp[i][j][k]=1;
					else if(i<j && j<k)
						dp[i][j][k]=dp[i][j][k-1]+dp[i][j-1][k-1]-dp[i][j-1][k-1];
					else
						dp[i][j][k]=dp[i-1][j][k]+dp[i-1][j-1][k]+dp[i-1][j][k-1]-dp[i-1][j-1][k-1];
				}
			}
		}
		
		String s = null;
		StringTokenizer st = null;
		int a, b, c;
		while(true) {
			s = br.readLine();
			if(s.equals("-1 -1 -1"))
				break;
			
			st = new StringTokenizer(s);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			sb.append("w("+a+", "+b+", "+c+") = ");
			if(a<=0 || b<=0 || c<=0)
				sb.append(1+"");
			else if(a>20 || b>20 || c>20)
				sb.append(dp[20][20][20]+"");
			else if(a<b && b<c)
				sb.append(dp[a][b][c-1]+dp[a][b-1][c-1]-dp[a][b-1][c]+"");
			else
				sb.append(dp[a-1][b][c]+dp[a-1][b-1][c]+dp[a-1][b][c-1]-dp[a-1][b-1][c-1]+"");
		
			sb.append("\n");
		}
		
		if(sb.length()>0)
			sb.delete(sb.length()-1, sb.length());
		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
		
	}

}
