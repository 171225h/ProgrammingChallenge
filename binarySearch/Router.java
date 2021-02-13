package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Router {

	// 2110�� 	2021.02.13.
	
	/*
	 * ó���� Ǭ Ǯ�̷� ���� �ȳ����� �׽�Ʈ ���̽��� ã�� ����
	 * ���� �ǿ� ������ �Ʒ��� ���� ���� ������ �� ������ Ʋ�ȴٴ� ���� �˾Ҵ�.
	 * https://www.acmicpc.net/board/view/8301
	 * 
	 * ����Ž���� �پ��ϰ� Ȱ���� �� �ִٴ� ���� �� �˰Ե� ����
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// �� ��
		int c = Integer.parseInt(st.nextToken());	// ��ġ�� ������

		int[] arr = new int[n];

		for(int i = 0; i<n; i++)
			arr[i]=Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		long left = 0;
		long right = arr[n-1]-arr[0];
		long mid=0;
		long result = mid;

		while(left<=right) {

			mid = (left+right)/2;

			if(promising(mid, c-1, arr)) {
				left = mid+1;
				result = Math.max(mid, result);
				//System.out.println("result = "+result);
			}
			else {
				right = mid-1;
			}
		}

		bw.write(result+"");
		bw.flush();
		bw.close();


	}

	/**
	 * length��ŭ �Ÿ��� �����鼭 router�� c�� ��ġ�� �� �ִ��� Ȯ���մϴ�.
	 * @param length	�Ÿ�
	 * @param count		router ����
	 * @param arr		router ��ġ�� �� ��ġ
	 * @return	��ġ�� �Ǹ� true, �ƴϸ� false
	 */
	private static boolean promising(long length, int count, int[] arr) {
		int temp = 0;

		for(int i = 1; i<arr.length; i++) {
			temp = temp + arr[i]-arr[i-1];
			if(temp>=length) {
				count--;
				temp = 0;
			}
		}

		if(count<=0)
			return true;
		else
			return false;
	}

}
