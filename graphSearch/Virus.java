package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Virus {

	// 2606¹ø 	2021.01.18.
	
	static int[][] graph;
	static int vertax;
	static boolean[] visited;
	
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		vertax = Integer.parseInt(br.readLine());
		graph = new int[vertax+1][vertax+1];
		visited = new boolean[vertax+1];
		int edge = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int x, y;
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		count = 0;
		dfs(1);
		
		bw.write((count-1)+"");
		bw.flush();
		bw.close();
		
	}

	public static void dfs(int now) {
		visited[now]=true;
		count++;
		
		for(int i = 1; i<=vertax; i++) {
			if(graph[now][i]==1 && !visited[i])
				dfs(i);
		}
	}

}
