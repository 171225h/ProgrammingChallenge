package divideAndConquer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Multiple {

	// 1629�� 2020.12.30.
	
	/*
	 * ��� ������ �־ �´µ� �� �ȵǴ��� ȭ�� �ܶ� ����.
	 * �ش��� acmicpc.net/board/view/43516 ���⿡ �־���.
	 * result�� int������ �ߴ���
	 * "2147483646 3 2147483647"�� overflow�� ����.
	 * 2147483646*2147483646��
	 * int���� ũ�⿡, �� ū �ڷ����� long�� ���� �ذ�Ǵ� ���̾���!
	 * �۾���ó�� ���� �ļ����ٴ� ������ ����µ� ���� ���Ͱ��� �ǵ��� �ƴ϶��
	 * ������ �� ũ���ְ� ����� ������ �Ǵٰ� �Ѵ�.
	 * �������� �Ű��� ���鼭 ������ Ǫ�� ������ �鿩�߰ڴ�.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long result = divideAndConquer(a, b, c);


		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	private static long divideAndConquer(int a, int b, int c) {
		if(b<=1)
			return a%c;
		else {
			long re = divideAndConquer(a, b/2, c);

			if(b%2==0)
				return ((re%c)*(re%c))%c;
			else
				return ( (((re%c)*(re%c))%c) * a )%c;
		}
	}

}
