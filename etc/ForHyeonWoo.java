package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ForHyeonWoo {
	
	// 3474�� 	2021.03.06.
	
	/*
	 * 1676���� ���� ����
	 * 5���� ���� ���� ���� n!���� 0�� �ȳ���
	 * ū ��쿡�� ������ 5�� 2���� ����
	 * 
	 * ����� �ٸ� ���� ���������� ���� ������ �ǹ̴�?
	 * �� �� �ȿ� � ���� ����� �� ���� �ִ��� �˷��ִ� ��
	 * �̰��� �̿��Ѵ�
	 * 
	 */

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		int temp;

		for(int i = 0; i<testCase; i++) {
			temp = Integer.parseInt(br.readLine());
			bw.write(countZero(temp)+"");

			if(i<testCase-1)
				bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	private static int countZero(int temp) {
		if(temp<5)
			return 0;

		int countFive = 0;
		for(int i = 5; i<=temp; i*=5) {
			countFive+=temp/i;
		}
		return countFive;
	}
}
