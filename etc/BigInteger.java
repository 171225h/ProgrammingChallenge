package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BigInteger {

	//10727번	2021.1.4.
	/*
	 * upper처리가 관건! 더하는 수 1, 2, 예전 upper까지 더해서 10으로 나누자.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder n1 = new StringBuilder(st.nextToken());
		StringBuilder n2 = new StringBuilder(st.nextToken());
		StringBuilder result = new StringBuilder();
		int upper = 0;
		int temp1 = 0;
		int temp2 = 0;
		
		if(n1.length()!=n2.length()) {
			while(n1.length()>n2.length())
				n2.insert(0, " ");
			
			while(n1.length()<n2.length())
				n1.insert(0, " ");
		}
		
		for(int i = n1.length()-1; i>-1; i--) {
			temp1 = (n1.charAt(i)==32) ? 0 : n1.charAt(i)-48;
			temp2 = (n2.charAt(i)==32) ? 0 : n2.charAt(i)-48;
			
			result.insert(0, (temp1+temp2+upper)%10);
			
			upper = (temp1+temp2+upper)/10;
		}
		
		if(upper != 0)
			result.insert(0, upper);
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
