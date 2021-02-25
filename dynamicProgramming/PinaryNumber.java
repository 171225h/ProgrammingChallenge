package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PinaryNumber {

	// 2193�� 	2021.02.22.
	
	/*
	 * n=1�� ��, 1
	 * n=2�� ��, 1
	 * n=3�� ��, 2
	 * n=4�� ��, 3
	 * n=5�� ��, 5
	 * n=6�� ��, 8
	 * 
	 * arr[i]=arr[i-1]+arr[i-2] ��Ģ!
	 * ��, n�� 1���� 90�ε� int���̸� �����÷ο찡 ����
	 * long������ arr�� ����� ����
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
