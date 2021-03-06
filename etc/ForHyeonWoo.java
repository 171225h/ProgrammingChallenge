package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ForHyeonWoo {
	
	// 3474번 	2021.03.06.
	
	/*
	 * 1676번과 같은 문제
	 * 5보다 작은 수일 경우는 n!에서 0이 안나옴
	 * 큰 경우에는 무조건 5가 2보다 많음
	 * 
	 * 어떤수를 다른 수로 나누었을때 몫이 가지는 의미는?
	 * 그 수 안에 어떤 수의 배수가 몇 개나 있는지 알려주는 것
	 * 이것을 이용한다
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
