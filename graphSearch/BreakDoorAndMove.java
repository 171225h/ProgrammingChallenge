package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakDoorAndMove {

	/*
	 * fail
	 * 2206
	 * 2022.03.24.
	 * 
	 * BFS문제를 조금 응용한 문제!
	 * 조건이 하나 추가되면서 벽을 뚫은경우는 어떻게 처리해야되는지 고민하게 했다
	 * 다음에 또 풀어봐야할듯...
	 * 
	 * 좋은 해설
	 * https://iseunghan.tistory.com/316
	 */
	
	static int[][] arr;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		String temp = null;
		arr = new int[n][m];

		for(int i = 0; i<n; i++) {

			temp = br.readLine();

			for(int j = 0; j<m; j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}

		int result = BFS();

		bw.write(result+"");
		bw.flush();
		bw.close();


	}

	private static int BFS() {

		int[][][] visited = new int[n][m][2];
		int[][] dist = new int[n][m];

		Queue<Integer> x_que = new LinkedList<>();
		Queue<Integer> y_que = new LinkedList<>();
		Queue<Integer> use_que = new LinkedList<>();

		int[] xList = {-1, 0, 1, 0};
		int[] yList = {0, -1, 0, 1};

		int curX = 0;
		int curY = 0;
		int curUse = 0;

		x_que.add(curX);
		y_que.add(curY);
		use_que.add(curUse);

		visited[0][0][0] = 1;
		dist[0][0] = 1;


		int tempX, tempY;

		while(!x_que.isEmpty()) {
			curX = x_que.poll();
			curY = y_que.poll();
			curUse = use_que.poll();

			if(curX==n-1 && curY==m-1)
				break;
			
			for(int i = 0; i<4; i++) {
				tempX = curX+xList[i];
				tempY = curY+yList[i];
				
				if(!checkRange(tempX, tempY))
					continue;
				
				// 다음 칸에 벽이 있을 때, 1
				// 1. 벽을 부순 적 있는가? 2. 벽을 방문한 적 있는가?
				if(arr[tempX][tempY]==1) {
					if(curUse==0 && visited[tempX][tempY][curUse] == 0) {
						visited[tempX][tempY][curUse] = 1;
						dist[tempX][tempY] = dist[curX][curY] + 1;
						
						x_que.add(tempX);
						y_que.add(tempY);
						use_que.add(1);
					}
				}
				// 벽이 아닐경우, 0
				// 벽을 부순 적 있는지에 따른 방문 체크하기, 방문하지 않았어야함
				else {
					if(visited[tempX][tempY][curUse]==0) {
						visited[tempX][tempY][curUse] = 1;
						dist[tempX][tempY] = dist[curX][curY]+1;
						
						x_que.add(tempX);
						y_que.add(tempY);
						use_que.add(curUse);
					}
				}
				
			}

		}


		return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
	}

	private static boolean checkRange(int tempX, int tempY) {

		if(tempX >= 0 && tempX < n && tempY >= 0 && tempY < m)
			return true;
		else
			return false;
	}

}
