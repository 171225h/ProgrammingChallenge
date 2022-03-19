package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KaingCalendar {

	/*
	 * fail
	 * 6064
	 * 2022.03.19.
	 * 
	 * 1�� ���� : �ּҰ���� ����� ���� ����
	 * 2�� ���� : �ð��ʰ�
	 * 
	 * 1�� ���ؼ� Ȯ���ϴ� ���� �ƴ϶� m�� ���ؼ� �ҿ�ð��� ���̴� ��� �̿�
	 * 
	 * ���� ����Ʈ
	 * https://mygumi.tistory.com/325
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int m, n, x, y, result, mnLCM;
		
		for(int i = 0; i<testCase; i++) {

			st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			// ����� ������ ����, default�� -1�� ���
			result = -1;
			
			// �ּҰ������ ���� �̰ͺ��� �� ū ���� ����� �� ���� ����
			mnLCM = lmc(m, n);
			
			
			for(int j = x; j<=mnLCM; j+=m) {
				
				// y���� n���� ���� ���, �������� n�� �ƴ� 0��!
				// ���� y%n == 0 �� ���� Ư������
				if(y%n==0 && j%n==0) {
					result = j;
					break;
				}
				else if(j%n==y) {
					result = j;
					break;
				}
			}
			
			bw.write(result+"");
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
	}
	
    public static int lmc(int num1, int num2){
    	return num1*num2/gcd(num1, num2);
    }

	
    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }

}
