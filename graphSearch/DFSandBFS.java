package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFSandBFS {

	// 1260¹ø 	2021.01.18.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertax = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		int[][] graph = new int[vertax+1][vertax+1];
		int x, y;

		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		
		String dfs = DFS(graph, stack, new HashSet<Integer>(), new StringBuilder());
		bw.write(dfs.substring(0, dfs.length()-1)+"\n");
		bw.write(BFS(graph, start)+"\n");
		
		bw.flush();
		bw.close();
	}

	public static String DFS(int[][] graph, Stack<Integer> stack, Set<Integer> set, StringBuilder sb) {
		if(stack.isEmpty())
			return sb.toString();
		else {
			int vertax = stack.pop();
			set.add(vertax);
			sb.append(vertax+" ");
			
			for(int i = 1; i<graph.length; i++) {
				if(graph[vertax][i]==1 && !set.contains(i)) {
					stack.add(i);
					DFS(graph, stack, set, sb);
				}
			}
			
			return sb.toString();
		}
	}

	public static String BFS(int[][] graph, int start) {
		StringBuilder sb = new StringBuilder();

		Set<Integer> set = new HashSet<>();
		Queue<Integer> que = new LinkedList<>();
		que.add(start);

		int vertax;

		while(!que.isEmpty()) {
			vertax = que.poll();

			if(!set.contains(vertax)) {
				sb.append(vertax+" ");

				set.add(vertax);

				for(int i = 1; i<graph.length; i++){
					if(graph[vertax][i]==1 && !set.contains(i))
						que.add(i);
				}
			}
		}

		sb.delete(sb.length()-1, sb.length());

		return sb.toString();

	}
}
