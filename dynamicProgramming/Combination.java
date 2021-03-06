package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination {

	// 2407번 	2021.03.06.
	
	/*
	 * BigInteger를 사용해서 조합을 구현하는 문제
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger[] temp = new BigInteger[2];
		Arrays.fill(temp, BigInteger.ONE);
		BigInteger[] next = null;
		for(int i = 2; i<=n; i++) {
			next = new BigInteger[i+1];
			next[0]=BigInteger.ONE;
			next[i]=BigInteger.ONE;
			for(int j = 1; j<i; j++) {
				next[j]=temp[j-1].add(temp[j]);
			}
			temp = next.clone();
		}
		
		bw.write(temp[m]+"");
		bw.flush();
		bw.close();
	}

}
