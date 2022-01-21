package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOIOI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i<n; i++) {
			temp.append("IO");
		}
		temp.append("I");
		
		String check = temp.toString();
		
		int cnt = 0;
		for(int i = 0; i < m-2*n; i++) {
			if(s.subSequence(i, i + check.length()).equals(check.toString()))
				cnt++;
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		
	}

}
