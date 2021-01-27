package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Combination3 {

	// 11401번 	2021.01.27.
	
	/*
	 * 페르마의 소정리란?
	 * 만약 p가 소수이고, a는 p로 나눠지지 않는 정수라면
	 * a^p-1과 1은 각각 p로 나누었을때 나머지가 같다
	 * 심지어, 모든 정수 a는
	 * a^p과 a는 각각 p로 나누었을때 나머지가 같다
	 */
	
	/*
	 * https://kyunstudio.tistory.com/60
	 * 결국 못풀어서 답을 봤다.
	 * 답을 봐도 이해하는데 오래걸렸다.
	 * 프로그래머도 수학적 이해력이 (꽤나) 필요하단 점을 알게된 문제...
	 * 사실 답을 안봤으면 못 풀었을 문제 ㅜ.ㅠ..
	 */
	
	static final int MAXINPUT = 4000000;	// 최대 4000000가 들어옵니다!
	static final int P = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long result = 0;

		long[] factorial = new long[MAXINPUT+1];	// factorial을 저장할 공간
		long[] inverseB = new long[MAXINPUT+1];		// k!(n-k)!%P와 합동인 x를 저장하자
		
		// factorial 계산
		factorial[1] = 1;
		for(int i = 2; i<=MAXINPUT; i++)
			factorial[i]=(factorial[i-1]*i)%P;
	
		// 1/(k!(n-k)!)%P와 합동인 x%p의 x를 구하는 과정
		inverseB[MAXINPUT] = power(factorial[MAXINPUT], P-2);
		for(int i = MAXINPUT-1; i> 0; i--)
			inverseB[i]=(inverseB[i+1]*(i+1))%P;
		
		// output
		if(n==k || k==0) {
			bw.write(1+"");
		}
		else {
			result = (factorial[n]*inverseB[n-k])%P;
			result = (result*inverseB[k])%P;
			bw.write(result+"");
		}
		bw.flush();
		bw.close();
	}

	/**
	 * 
	 * @param x 밑
	 * @param y 지수
	 * @return B%P와 합동인 x%P의 x
	 */
	private static long power(long x, int y) {
		long result = 1;
		
		while(y>0) {
			if(y%2==1) {
				result *= x;
				result %= P;
			}
			x *= x;
			x %= P;
			y /= 2;
		}
		
		return result;
	}

}
