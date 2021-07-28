package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StarPrinting10{	

	// 2447번 	2020.2.11.
	/*
	 * 성호의 훈련소 생활을 즐겁게 만들어보자
	 */
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		int n = Integer.parseInt(br.readLine());

		char[][] stars = new char[n][n];

		// stars를 *로 채움
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++)
				stars[i][j] = '*';
		}

		// 본격적으로 모양을 만들어보자
		makeSpace(stars, n);

		// output
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++)
				bw.write(stars[i][j]+"");
			bw.write("\n");
		}		

		bw.flush();
		bw.close();

	}

	public static void makeSpace(char[][] stars, int n) {
		if(n==1)
			return;
		else {
			for(int i = 0; i<stars.length; i++) {
				for(int j = 0; j<stars.length; j++) {
					if((i%n >= n/3 && i%n < (n/3)*2 ) && (j%n>=n/3 && j%n < (n/3)*2))
						stars[i][j] = ' ';
				}
			}

			makeSpace(stars, n/3);
		}
	}
}