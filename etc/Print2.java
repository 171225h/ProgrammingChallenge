package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Print2 {

	// 11719번 	2021.01.27.
	
	/*
	 * 더 이상 읽을 게 없을 때 프로그램을 종료하는 법을 배우는 문제!
	 * JAVA는 Scanner와 BufferedReader에서 해야하는 처리가 서로 다르다!
	 * Scanner는 NoSuchElementExcepion을 던지고
	 * BufferedReader는 null을 던진다는 차이가 있다!
	 * 
	 * 종료조건은 ctrl+z해주면 된당
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		while(s!=null){			
			bw.write(s+"\n");
			s= br.readLine();
		}

		bw.flush();
		bw.close();
	}

}
