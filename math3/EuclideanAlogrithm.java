package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class EuclideanAlogrithm {
	// 1934��	2021.01.08.

	/*
	 * ��Ŭ���� �˰����� �� ������ Ǯ���
	 * ��Ŭ���� �˰����̶�? : �� ���� �ִ� ������� ���ϴ� �˰���
	 * 
	 * 1. ū ���� ���� ���� ������
	 * 2. 1���� ������� �������� �� �� �� ū ���� ������.
	 * 3. �������� 0�� �� �� ���� 1�� 2�� �ݺ��Ѵ�.
	 * 
	 * �� ���� ���� �� �ִ� ������� ������ �ּҰ������ ���� �� �ִ�.
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
	 * @param num1	�ִ������� �ñ��� ��1
	 * @param num2	�ִ������� �ñ��� ��2
	 * @return		num1, num2�� �ִ� �����
	 */
	private static int GCD(int num1, int num2) {
		int a = num1>num2 ? num1 : num2;	// ū ��
		int b = num1>num2 ? num2 : num1;	// ���� ��
		int temp = 0;						// �������� ������ temp
			
		while(b!=0) {
			temp = a%b;
			a = b;
			b = temp;
		}
		
		return a;
	}

}
