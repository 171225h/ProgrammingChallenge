package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sticker {

	// 9465번 	2021.02.22.

	/*
	 * 선택에 어떤 규칙이 있는 것까진 알아냈지만
	 * 점화식 만들기를 실패함
	 */

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		int n=0;
		int[][] arr=null;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for(int i = 0; i<testCase; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[2][n];

			// 각 testCase input
			for(int j = 0; j<2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<n; k++) 
					arr[j][k]=Integer.parseInt(st.nextToken());

			}

			//dp
			if(n==1)
				sb.append(Math.max(arr[0][0], arr[0][1])+"");
			else if(n==2)
				sb.append(Math.max(arr[0][0]+arr[1][1], arr[0][1]+arr[1][0]));
			else {
				// 답
				arr[0][1] += arr[1][0];
				arr[1][1] += arr[0][0];
				
				for(int j = 2; j<n; j++) {
					// 처음 비슷하게 생각해낸 것
					//arr[0][j] += Math.max(arr[0][j-2]+arr[1][j-1], arr[1][j-2]);
					//arr[1][j] += Math.max(arr[1][j-2]+arr[0][j-1], arr[0][j-2]);
				
					// 답
					arr[0][j] += Math.max(arr[1][j-1], arr[1][j-2]);
					arr[1][j] += Math.max(arr[0][j-1], arr[0][j-2]);
				}

				sb.append(Math.max(arr[0][n-1], arr[1][n-1]));
			}

			if(i<testCase-1)
				sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
