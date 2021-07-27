package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PokemonMaster {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> nameSet = new HashMap<>();
		Map<Integer, String> numberSet = new HashMap<>();
		
		for(int i = 1; i<=n; i++) {
			s = br.readLine();
			nameSet.put(s, i);
			numberSet.put(i, s);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			s = br.readLine();
			if(s.charAt(0)>='A' && s.charAt(0)<='Z')
				sb.append(nameSet.get(s)+"\n");
			else
				sb.append(numberSet.get(Integer.parseInt(s))+"\n");
		}
		
		sb.delete(sb.length()-1, sb.length());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
