package math3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class FashionKing {

	// 9375번 2020.12.27.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		int n = 0;

		Map<String, Integer> map = null;
		StringTokenizer st = null;
		String item = null;
		
		int result = 0;

		for(int i = 0; i<testCase; i++) {
			map = new HashMap<>();
			result = 1;
			n = Integer.parseInt(br.readLine());

			// item 받기
			for(int j = 0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();	// 앞 단어 버리기
				
				item = st.nextToken();
				if(map.containsKey(item))
					map.put(item, map.get(item)+1);
				else
					map.put(item, 1);
			}
			
			Iterator<Integer> iter = map.values().iterator();
			while(iter.hasNext())
				result*=(iter.next()+1);
		

			bw.write((result-1)+"\n");
		}
		
		bw.flush();
		bw.close();
	
	}

}
