package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Print2 {

	// 11719�� 	2021.01.27.
	
	/*
	 * �� �̻� ���� �� ���� �� ���α׷��� �����ϴ� ���� ���� ����!
	 * JAVA�� Scanner�� BufferedReader���� �ؾ��ϴ� ó���� ���� �ٸ���!
	 * Scanner�� NoSuchElementExcepion�� ������
	 * BufferedReader�� null�� �����ٴ� ���̰� �ִ�!
	 * 
	 * ���������� ctrl+z���ָ� �ȴ�
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
