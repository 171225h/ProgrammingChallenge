package divideAndConquer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Multiple {

	// 1629번 2020.12.30.
	
	/*
	 * 모든 예제를 넣어도 맞는데 왜 안되는지 화가 잔뜩 났다.
	 * 해답은 acmicpc.net/board/view/43516 여기에 있었다.
	 * result를 int값으로 했더니
	 * "2147483646 3 2147483647"에 overflow가 났다.
	 * 2147483646*2147483646가
	 * int보다 크기에, 더 큰 자료형인 long을 쓰면 해결되는 것이었다!
	 * 글쓴이처럼 뭔가 꼼수같다는 생각이 들었는데 만약 위와같은 의도가 아니라면
	 * 범위도 더 크게주고 제출언어도 제한을 건다고 한다.
	 * 범위에도 신경을 쓰면서 문제를 푸는 습관을 들여야겠다.
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
