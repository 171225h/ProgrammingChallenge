package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Remote_controller {

	static boolean[] broken;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		 * 2022.01.19. 1107 fail
		 * 
		 * brute force문제, 문해프때 푼 방법을 적용할까 했는데 범위가 너무 크다
		 * 늘 brute force문제를 못푸는데 이것도 못풀었다 아쉽다.
		 * 나누기를 이용해서 가장 가까운 수로 어떻게 이동할까 생각했는데
		 * 0부터 1000000까지 쭉 돌면서 움직인다니 ㅇ0ㅇ....
		 * 생각도 못한 방법... 더 열심히 하자 
		 */
		
		int end = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		broken = new boolean[10];
		
		if(n!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		int min_count = Math.abs(end-100);			// +, -로만 움직였을 때!

		int temp = 0;
		for(int i = 0; i<1000000; i++) {
			temp = count(i);
			if(temp>0)
				min_count = Math.min(min_count, Math.abs(end-i)+temp);
		}

		bw.write(min_count+"");
		bw.flush();
		bw.close();

	}

	private static int count(int i) {
		if(i==0)
			if(broken[0])
				return 0;
			else
				return 1;

		int len = 0;
		while(i>0) {
			if(broken[i%10])
				return 0;
			i /= 10;
			len += 1;
		}
		return len;
	}

}
