package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class ConnectedComponent {
	
	// 11724번 2021.07.27.
	
	/*
	 * graph serch로 푸는거같은데 잘 모르겠어서
	 * 완전탐색으로 푼거같다
	 * 더 좋은 해법이 있는지 찾아봐야겠다.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n+1][n+1];

		int a = 0;
		int b = 0;
		for(int i = 0; i<m; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			graph[a][b]=1;
			graph[b][a]=1;
		}

		int result = counter(graph, n);

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	private static int counter(int[][] graph, int vertex) {
		ArrayList<Set<Integer>> setList = new ArrayList<>();
		Set<Integer> temp = null;
		Set<Integer> setTemp = null;

		for(int i = 1; i<=vertex; i++) {
			temp = new HashSet<>();
			temp.add(i);

			for(int j = 1; j<=vertex; j++) {
				if(i==j || graph[i][j]==0) 
					continue;
				temp.add(j);			
			}

			boolean find = false;
			for(int j = 0; j<setList.size(); j++) {
				setTemp = setList.get(j);

				Iterator<Integer> iter = temp.iterator();

				while(iter.hasNext()) {
					if(setTemp.contains(iter.next())) {
						setTemp.addAll(temp);
						setList.remove(j);
						setList.add(setTemp);
						find =true;
						break;
					}

				}
			}
			if(!find)
				setList.add(temp);

		}

		return setList.size();
	}

}
