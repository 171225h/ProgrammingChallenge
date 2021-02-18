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

	// 7576�� 	2021.02.18.
	
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
	 * �丶�䰡 �ʹ� ���� ����մϴ�.
	 * 
	 * @param box 	�丶���� ���¸� �˷��ִ� arr
	 * @param n		�丶�� ���� ĭ ��
	 * @param m		�丶�� ���� ĭ ��
	 * @return		ó������ �� �;����� 0
	 * 				��¥�� �� ��, �� �;����� �� ��¥�� return
	 *				�� ���� �ʴ´ٸ� -1�� return
	 */
	private static int BFS(int[][] box, int n, int m) {
		if(done(box))	// ó������ ��� 1�̸� return 0;
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

		if(done(box))	// ��¥ ���⸦ ���� ��, �� ���� �丶�丸 �ִٸ� count
			return count;
		else			// �ƴϸ� -1
			return -1;
	}

	/**
	 * ���� �丶���� ��ǥ�� queue�� �־��ش�
	 * @param box	�丶�䰡 ����ִ� ����
	 * @return		���� �丶���� ��ǥ�� ����ִ� queue 
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
	 * �丶�䰡 �� �;����� Ȯ���ϴ� �޼ҵ�
	 * @param box	�丶�䰡 �� ����
	 * @return		�� ������ true, �ƴϸ� false
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

