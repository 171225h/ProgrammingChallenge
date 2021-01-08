package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class EuclideanAlogrithm {
	// 1934번	2021.01.08.

	/*
	 * 유클리드 알고리즘을 더 빠르게 풀어보자
	 * 유클리드 알고리즘이란? : 두 수의 최대 공약수를 구하는 알고리즘
	 * 
	 * 1. 큰 수를 작은 수로 나눈다
	 * 2. 1에서 만들어진 나머지로 두 값 중 큰 수를 나눈다.
	 * 3. 나머지가 0이 될 때 까지 1과 2를 반복한다.
	 * 
	 * 두 수를 곱한 후 최대 공약수로 나누면 최소공배수를 얻을 수 있다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	  
	      int testCase = Integer.parseInt(br.readLine());
	      StringTokenizer st = null;
	      int num1, num2;
	      int gcd = 0;
	      for(int i = 0; i<testCase; i++) {
	    	  st = new StringTokenizer(br.readLine());
	    	  num1 = Integer.parseInt(st.nextToken());
	    	  num2 = Integer.parseInt(st.nextToken());

	    	  gcd = GCD(num1, num2);
	    	  
	    	  bw.write((num1*num2)/gcd+"");
	    	  
	    	  if(i<testCase-1)
	    		  bw.write("\n");
	      }
	      
	      bw.flush();
	      bw.close();
	}

	/**
	 * 
	 * @param num1	최대공약수가 궁금한 수1
	 * @param num2	최대공약수가 궁금한 수2
	 * @return		num1, num2의 최대 공약수
	 */
	private static int GCD(int num1, int num2) {
		int a = num1>num2 ? num1 : num2;	// 큰 수
		int b = num1>num2 ? num2 : num1;	// 작은 수
		int temp = 0;						// 나머지를 저장할 temp
			
		while(b!=0) {
			temp = a%b;
			a = b;
			b = temp;
		}
		
		return a;
	}

}
