package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze {

	// 2178번 	2021.02.18.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[n][m];
		String s = null;
		for(int i = 0; i<n; i++) {
			s = br.readLine();
			for(int j = 0; j<m; j++) {
				maze[i][j] = s.charAt(j)-'0';
			}
		}
		
		//BFS
		int result = BFS(maze, n, m);
		
		//Output
		bw.write(result+"");
		bw.flush();
		bw.close();
		
		
		
	}

	private static int BFS(int[][] maze, int n, int m) {
		Queue<Location> que = new LinkedList<>();
		int result = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[n][m];
		
		int[] nextX = {0, -1, 0, 1};
		int[] nextY = {1, 0, -1, 0};

 		visited[0][0] = true;			// 0, 0 방문표시
		que.add(new Location(0, 0, 1));	// que에 넣어줍니다
		
		Location temp = null;
		int x, y;
		int tempX, tempY;
		
		while(!que.isEmpty()) {
			
			temp = que.poll();	
			x = temp.getX();
			y = temp.getY();
			
			if(x==n-1 && y==m-1) {
				result = Math.min(result, temp.getCount());
			}
			
			for(int i = 0; i<4; i++) {	// 인접한 좌표를 모두 확인
				tempX = x+nextX[i];
				tempY = y+nextY[i];
				// 좌표가 범위 내의 수이고, 다음 칸이 갈 수 있는 칸이며, 방문하지 않았을 때만 inque해줌
				if(tempX >=0 && tempX<n && tempY>=0 && tempY<m && maze[tempX][tempY]==1 && !visited[tempX][tempY]) {
					visited[tempX][tempY] = true;
					que.add(new Location(tempX, tempY, temp.getCount()+1));
				}
			}
			
			
		}
		
		return result;
	}

}

class Location{
	
	int x;
	int y;
	int count;
	
	public Location(int x, int y, int count) {
		this.x=x;
		this.y=y;
		this.count=count;
	}
	
	public Location(int x, int y) {
		this(x, y, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getCount() {
		return count;
	}
}
