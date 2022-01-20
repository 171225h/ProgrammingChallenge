package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindPath {

	/*
	 * 2022.01.20.
	 * 11403
	 * 
	 * 어떻게 풀 지 생각이 안나서 BFS로 풀었다..
	 * 플로이드 와샬 알고리즘을 생각 못했으니 이번 기회에 다시 공부해야겠다.
	 */
	
	static int[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		// node 수
		int n = Integer.parseInt(br.readLine());

		// 출력할 array(어차피 출력할때도 쓰고, 저장할때도 써서 그냥 만들음)
		result = new int[n][n];

		int temp = 0;

		// input
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j<n; j++) {
				temp = Integer.parseInt(st.nextToken());

				if(temp==1)
					result[i][j] = 1;
			}
		}

		// 갈 수 있는 node 계산
		for(int i = 0; i<n; i++) {
			BFS(i, n);
		}

		// output
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				bw.write(result[i][j]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

	private static void BFS(int start, int n) {
		Queue<Integer> que = new LinkedList<>();

		// start에서 갈 수 있는 애들 일단 que에 저장
		for(int i = 0; i<n; i++)
			if(result[start][i]==1)
				que.add(i);

		int temp = 0;

		while(!que.isEmpty()) {

			temp = que.poll();

			for(int i = 0; i<n; i++)
				// start에서 갈 수 있고, 방문하는 줄 몰랐다면 진행
				if(result[temp][i]==1 && result[start][i]==0) {
					result[start][i] = 1;
					// 결론적으로 여기에 있는 애들도 갈 수 있단 얘기니까 얘도 que에 넣어준다.
					que.add(i);
				}
		}
	}
}