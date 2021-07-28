package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Z {
	
	// 1074번 2021.07.29.
	
	/*
	 * 진짜 하루종일 푼 문제 ㅜㅜ
	 * 풀다보니 오기가 생겨서 답 보기 싫어서 하루종일 매달림
	 * 재귀에 조금 약한거같고...또 종료조건을 좀 더 유심히 보기!
	 */
	
	static int n;
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		n = (int)Math.pow(2, n);
		
		long result = find(0, 0, 0, n*n);
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	private static long find(long n, long m, long s, long e) {
		//System.out.println("n = "+n+", m = "+m+", start = "+s+", end = "+e);
		if(e-s<=1) 
			return s;
		
		long len = (e-s);
		long div4 = len/4;
		long posLen = (int)Math.sqrt(len);
		long result = 0;
		
		if(r<n+(posLen/2) && c<m+(posLen/2)) {
			result = find(n, m, s, s+div4);
		}
		else if(r<n+(posLen/2) && c>=m+(posLen/2)) {
			result = find(n, m+(posLen/2), s+div4, s+div4*2);
		}
		else if(r>=n+(posLen/2) && c<m+(posLen/2)) {
			result = find(n+(posLen/2), m, s+div4*2, s+div4*3);
		}
		else {
			result = find(n+(posLen/2), m+(posLen/2), s+div4*3, s+div4*4);
		}
		
		
		return result;
	}

}
