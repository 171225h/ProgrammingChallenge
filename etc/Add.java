package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Add {

	// 9095번	2021.02.13.
	
	/*
	 * 풀면서 아.. DP로 풀 수 있을 것 같은데..
	 * 란 생각이 들었지만 그냥 brute force로 풀었다.
	 * input이 최대가 10이라 그냥 이렇게 풀어도 될거같아서..
	 * 
	 * dp문제를 좀 더 연습해보자
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		int n, result;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<testCase; i++) {
			n = Integer.parseInt(br.readLine());
			result = OneTwoThreeAdd(n);
		
			sb.append(result);
			if(i<testCase-1)
				sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int OneTwoThreeAdd(int n) {
		int result = 1;
		
		int three = 0;
		int two = 0;
		int one = n;
		
		for(int i = 1; i <= n/2; i++) {
			two = i;
			one = n - 2*two;
			
			result += lineUP(two, one);
		}
		
		for(int i = 1; i<= n/3; i++) {
			three = i;
			one = n - 3*three;
			for(int j = 0; j<= one/2; j++) {
				two = j;
				result += lineUp(three, two, n-3*three-2*two);
			}
		}
		
		
		
		return result;
	}

	private static int lineUp(int three, int two, int one) {
		int result = 1;
		int sum = three+two+one;
		
		for(int i = 1; i<=sum; i++) {
			result*=i;
		}
		
		for(int i = 1; i<=three; i++) {
			result/=i;
		}
		
		for(int i = 1; i<=two; i++) {
			result/=i;
		}
		
		for(int i = 1; i<=one; i++) {
			result/=i;
		}
		
		return result;
	}

	private static int lineUP(int two, int one) {
		return lineUp(0, two, one);
	}

}
