package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IncreasingNumber {

	// 11057번 	2021.02.21.
	
	/*
	 * 1 1 1 1 ... 1
	 * 1 2 3 4 ... 10
	 * 1 3 6 10 ... 55
	 * 
	 * 위와 같은 식으로 움직이는 것을 알았다.
	 * n=1일때, 값은 10	n=0일때 수를 모두 더한 것
	 * n=2일때, 값은 55	n=1일때 수를 모두 더한 것
	 * n=3일땐, 값은 220	n=2일때 수를 모두 더한 것이다.
	 * 
	 * 또, arr[i]의 값이 현재 arr[i-1]과 이전의 arr[i]의 값을 합친 것이란 규칙이 보였다.
	 * 
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int mod = 10007;
		int[] arr = new int[10];
		
		for(int i = 0; i<10; i++)	// 일단 default인 1로 채워준다.
			arr[i]=1;
		
		int sum = 0;
		for(int i = 0; i<n; i++) {	
			sum = 1;					// 아래 for문이 1부터 시작하니 일단 1값을 넣는다.	
			for(int j = 1; j<10; j++) {	
				
				sum = (sum+arr[j])%mod;	// arr[9]의값을 만들어줄 sum
				
				if(j==9)
					arr[j]=sum;
				else 
					arr[j] = (arr[j]+arr[j-1])%mod;
				
			}
		}
		
		bw.write(arr[9]+"");
		bw.flush();
		bw.close();
	}

}
