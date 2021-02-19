package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenBlindness {
	
	// 10026번 	2021.02.19.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// input
		int[][] arr = new int[n][n];
		String s = null;
		for(int i = 0; i<n; i++) {
			s = br.readLine();
			for(int j = 0; j<n; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		// BFS
		int[] result = count(arr, n);

		// output
		bw.write(result[0]+" "+result[1]+"");
		bw.flush();
		bw.close();
	}

	/**
	 * 적록색맹과 적록색맹이 아닌 사람이 보는 구역의 개수를 담은 arr를 반환
	 * @param arr	RGB구역
	 * @param n		RGB구역 크기
	 * @return		적록색맹과 적록색맹이 아닌 사람이 보는 구역의 개수를 담은 arr
	 */
	private static int[] count(int[][] arr, int n) {
		int[] result = new int[2];

		boolean[][] visited = new boolean[n][n];
		int count = 0;
		// not blindness
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!visited[i][j]) {
					visited=area(i, j, arr[i][j], arr, visited, false);
					count++;
				}
			}
		}
		result[0]=count;

		// blindness
		visited = new boolean[n][n];
		count=0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!visited[i][j]) {
					visited=area(i, j, arr, visited, true);
					count++;
				}
			}
		}
		result[1]=count;


		return result;
	}

	/**
	 * 주어진 color와 같은 색을 가진 곳만 BFS로 탐색
	 * @param x			초기 x좌표
	 * @param y			초기 y좌표
	 * @param arr		RGB구역
	 * @param visited	방문 여부
	 * @param blindness	적록색맹이 봤을 때라면 true, 아니면 false
	 * @return			주어진 color와 같은 색을 가진 곳만 BFS로 탐색된 곳에 true를 쓴 boolean arr
	 */
	private static boolean[][] area(int x, int y, int[][] arr, boolean[][] visited, boolean blindness) {
		int[] nextX = {1, -1, 0, 0};
		int[] nextY = {0, 0, 1, -1};

		int tempX, tempY;
		int color = arr[x][y];
		Queue<Location> que = new LinkedList<>();
		Location temp = new Location(x, y);
		visited[x][y]=true;
		que.add(temp);

		if(blindness) {
			while(!que.isEmpty()) {

				temp = que.poll();

				for(int i = 0; i<4; i++) {
					tempX = temp.getX()+nextX[i];
					tempY = temp.getY()+nextY[i];	

					if(tempX>=0 && tempX<arr.length && tempY>=0 && tempY<arr.length && !visited[tempX][tempY])
						if(color=='R' || color=='G') {
							if(arr[tempX][tempY]=='G' || arr[tempX][tempY]=='R') {
								visited[tempX][tempY]=true;
								que.add(new Location(tempX, tempY));
							}
						}
						else {
							if(color==arr[tempX][tempY]) {
								visited[tempX][tempY]=true;
								que.add(new Location(tempX, tempY));
							}
						}

				}
			}
		}
		else {
			while(!que.isEmpty()) {

				temp = que.poll();

				for(int i = 0; i<4; i++) {
					tempX = temp.getX()+nextX[i];
					tempY = temp.getY()+nextY[i];	

					if(tempX>=0 && tempX<arr.length && tempY>=0 && tempY<arr.length && !visited[tempX][tempY])

						if(color==arr[tempX][tempY]) {
							visited[tempX][tempY]=true;
							que.add(new Location(tempX, tempY));
						}


				}
			}
		}

		return visited;
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

