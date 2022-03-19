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
	 * 1차 관문 : 최소공배수 만드는 법을 잊음
	 * 2차 관문 : 시간초과
	 * 
	 * 1씩 더해서 확인하는 것이 아니라 m씩 더해서 소요시간을 줄이는 방법 이용
	 * 
	 * 참고 사이트
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
			
			// 결과를 저장할 변수, default는 -1을 출력
			result = -1;
			
			// 최소공배수를 구함 이것보다 더 큰 값이 결과가 될 수는 없음
			mnLCM = lmc(m, n);
			
			
			for(int j = x; j<=mnLCM; j+=m) {
				
				// y값과 n값이 같은 경우, 나머지가 n이 아닌 0임!
				// 따라서 y%n == 0 일 때만 특수조건
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
