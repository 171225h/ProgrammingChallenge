package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Check {
	
	// 2981��	2020.12.31.
	
	/*
	 * 2���� ���� ū n���� ������ Ǯ�����ϴ� �ð��ʰ��� ����.
	 * �ƹ��� �����ص� �� �𸣰ھ Ǯ�̸� �ô�.
	 * https://pangsblog.tistory.com/62
	 * 
	 * ���� ���� �����س��� �κ��� ���� �� ����.
	 * ���� ���й����� ���� �����ؼ� Ǫ�� ���� ������ ���ƾ߰ڴ�.
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
