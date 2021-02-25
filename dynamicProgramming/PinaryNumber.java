package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PinaryNumber {

	// 2193번 	2021.02.22.
	
	/*
	 * n=1일 때, 1
	 * n=2일 때, 1
	 * n=3일 때, 2
	 * n=4일 때, 3
	 * n=5일 때, 5
	 * n=6일 때, 8
	 * 
	 * arr[i]=arr[i-1]+arr[i-2] 규칙!
	 * 또, n은 1부터 90인데 int형이면 오버플로우가 난다
	 * long형으로 arr를 만들어 주자
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n+1];
		
		for(int i = 1; i<3 && i<n+1; i++)
			arr[i]=1;
		
		for(int i =3; i<n+1; i++)
			arr[i]=arr[i-1]+arr[i-2];
		
		bw.write(arr[n]+"");
		bw.flush();
		bw.close();
	}

}
