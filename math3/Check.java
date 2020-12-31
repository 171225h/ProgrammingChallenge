package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Check {
	
	// 2981번	2020.12.31.
	
	/*
	 * 2부터 가장 큰 n까지 나눠서 풀려고하니 시간초과가 났다.
	 * 아무리 생각해도 잘 모르겠어서 풀이를 봤다.
	 * https://pangsblog.tistory.com/62
	 * 
	 * 수학 식을 도출해내는 부분이 약한 것 같다.
	 * 다음 수학문제는 식을 도출해서 푸는 것을 연습해 보아야겠다.
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		int[] arr = new int[testCase];

		// input
		for(int i = 0; i<testCase; i++)
			arr[i]=Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int gdc = arr[1]-arr[0];
		int temp2 = 0;

		for(int i = 2; i<testCase; i++) {
			temp2 = arr[i]-arr[i-1];		//a[i]-a[i-1]

			gdc = GCD(gdc, temp2);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(gdc);

		for(int i = gdc-1; i>=2; i--) {
			if(gdc%i==0)
				sb.insert(0, i+" ");
		}

		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();

	}

	private static int GCD(int temp1, int temp2) {
		int result = 1;

		for(int i = 2; i<=temp1 && i<=temp2; i++) {
			while(temp1%i==0 && temp2%i==0) {
				temp1/=i;
				temp2/=i;
				result*=i;
			}
		}

		return result;
	}

}
