package divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Combination3 {

	// 11401�� 	2021.01.27.
	
	/*
	 * �丣���� ��������?
	 * ���� p�� �Ҽ��̰�, a�� p�� �������� �ʴ� �������
	 * a^p-1�� 1�� ���� p�� ���������� �������� ����
	 * ������, ��� ���� a��
	 * a^p�� a�� ���� p�� ���������� �������� ����
	 */
	
	/*
	 * https://kyunstudio.tistory.com/60
	 * �ᱹ ��Ǯ� ���� �ô�.
	 * ���� ���� �����ϴµ� �����ɷȴ�.
	 * ���α׷��ӵ� ������ ���ط��� (�ϳ�) �ʿ��ϴ� ���� �˰Ե� ����...
	 * ��� ���� �Ⱥ����� �� Ǯ���� ���� ��.��..
	 */
	
	static final int MAXINPUT = 4000000;	// �ִ� 4000000�� ���ɴϴ�!
	static final int P = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long result = 0;

		long[] factorial = new long[MAXINPUT+1];	// factorial�� ������ ����
		long[] inverseB = new long[MAXINPUT+1];		// k!(n-k)!%P�� �յ��� x�� ��������
		
		// factorial ���
		factorial[1] = 1;
		for(int i = 2; i<=MAXINPUT; i++)
			factorial[i]=(factorial[i-1]*i)%P;
	
		// 1/(k!(n-k)!)%P�� �յ��� x%p�� x�� ���ϴ� ����
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
	 * @param x ��
	 * @param y ����
	 * @return B%P�� �յ��� x%P�� x
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
