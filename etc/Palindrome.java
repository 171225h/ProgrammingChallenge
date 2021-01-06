package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Palindrome {

	// 1920¹ø	2021.01.06.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0"))
				break;
			
			boolean isPalindrome = true;
			
			for(int i = 0; i<s.length()/2; i++) {
				if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
					isPalindrome=false;
					break;
				}
			}
			
			if(isPalindrome)
				sb.append("yes");
			else
				sb.append("no");
			
			sb.append("\n");
		}
		
		sb.delete(sb.length()-1, sb.length());
		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
	}

}
