package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SetProblem {

	// 11723번 2021.07.29.
	
	/*
	 * HashSet으로 해결!
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> one2twenty = new HashSet<>();
		String s = null;
		StringTokenizer st = null;
		
		for(int i = 1; i<21; i++)
			one2twenty.add(i);
		
		int n = Integer.parseInt(br.readLine());
		String man = null;
		int number = 0;
		
		for(int i = 0; i<n; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			
			man = st.nextToken();
			if(!man.equals("all") && !man.equals("empty"))
				number = Integer.parseInt(st.nextToken());
			
			if(man.equals("add"))
				set.add(number);
			else if(man.equals("remove"))
				set.remove(number);
			else if(man.equals("check"))
				sb.append( ((set.contains(number)) ? 1 : 0) + "\n");
			else if(man.equals("toggle"))
				if(set.contains(number))
					set.remove(number);
				else
					set.add(number);
			else if(man.equals("all"))
				set.addAll(one2twenty);
			else
				set.clear();
		}
		
		if(sb.length()>0)
			sb.delete(sb.length()-1, sb.length());
		
		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
		
	}

}
