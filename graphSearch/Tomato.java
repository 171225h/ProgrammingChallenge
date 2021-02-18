package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {

	// 7576번 	2021.02.18.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] box = new int[n][m];

		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				box[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int result = BFS(box, n, m);

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	/**
	 * 토마토가 익는 날을 계산합니다.
	 * 
	 * @param box 	토마토의 상태를 알려주는 arr
	 * @param n		토마토 세로 칸 수
	 * @param m		토마토 가로 칸 수
	 * @return		처음부터 다 익었으면 0
	 * 				날짜를 센 후, 다 익었으면 센 날짜를 return
	 *				다 익지 않는다면 -1을 return
	 */
	private static int BFS(int[][] box, int n, int m) {
		if(done(box))	// 처음부터 모두 1이면 return 0;
			return 0;

		int[] nextX = {0, -1, 0, 1};
		int[] nextY = {1, 0, -1, 0};
		Queue<Location> que = addTomatoLocation(box);

		int count = 0;
		int tempX, tempY;

		Location temp = null;
		while(!que.isEmpty()) {
			temp = que.poll();
			count=temp.getCount();
			for(int i = 0; i<4; i++) {
				tempX = temp.getX()+nextX[i];
				tempY = temp.getY()+nextY[i];

				if(tempX>=0 && tempX<n && tempY>=0 && tempY<m && box[tempX][tempY]==0) {
					box[tempX][tempY]=1;
					que.add(new Location(tempX, tempY, temp.getCount()+1));
				}
			}
		}

		if(done(box))	// 날짜 세기를 끝난 후, 다 익은 토마토만 있다면 count
			return count;
		else			// 아니면 -1
			return -1;
	}

	/**
	 * 익은 토마토의 좌표를 queue에 넣어준다
	 * @param box	토마토가 들어있는 상자
	 * @return		익은 토마토의 좌표가 들어있는 queue 
	 */
	private static Queue<Location> addTomatoLocation(int[][] box) {
		Queue<Location> que = new LinkedList<>();

		for(int i = 0; i<box.length; i++) {
			for(int j = 0; j<box[0].length; j++)
				if(box[i][j]==1)
					que.add(new Location(i, j));
		}
		return que;
	}

	/**
	 * 토마토가 다 익었는지 확인하는 메소드
	 * @param box	토마토가 든 상자
	 * @return		다 익으면 true, 아니면 false
	 */
	private static boolean done(int[][] box) {
		for(int i = 0; i<box.length; i++) {
			for(int j = 0; j<box[0].length; j++)
				if(box[i][j]==0)
					return false;
		}

		return true;
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

