package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FindANumber {

	// 1920번	2021.01.06.
	
	/*
	 * 자료구조 set을 활용하면 간단히 풀리는 문제
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Set<Integer> set = new HashSet<>();
		
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			set.add(Integer.parseInt(st.nextToken()));

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			if(set.contains(Integer.parseInt(st.nextToken())))
				bw.write(1+"");
			else
				bw.write(0+"");
			
			if(i<n-1)
				bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		

	}

}
