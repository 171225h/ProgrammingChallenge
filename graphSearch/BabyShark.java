package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {

	/*
	 * fail
	 * 16236
	 * 2022.03.21.
	 * 
	 * BFS를 이용해서 풀 수 있는 문제
	 * 
	 * 신경써줘야할 상어 크기, 어떤 물고기부터 먹어야할지
	 * 신경쓸게 많아서 하나를 까먹으면 계속 틀리게된다...
	 * 문제를 좀 꼼꼼히 읽어야할 필요가 있음
	 * 
	 */
	
	static int bShark = 2;
	static int pos_x;
	static int pos_y;
	static int cnt = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;


		int n = Integer.parseInt(br.readLine());
		int temp = 0;

		arr = new int[n][n];


		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				temp = Integer.parseInt(st.nextToken());

				arr[i][j] = temp;

				if(temp==9) {
					pos_x = i;
					pos_y = j;
					arr[i][j] = 0;
				}
			}
		}

		int result = eat_fish();

		bw.write(result+"");
		bw.flush();
		bw.close();

	}

	public static int eat_fish() {

		int result = 0;
		int temp = 0;
		boolean done = false;

		while(!done) {
			temp = BFS();

			if(temp == Integer.MAX_VALUE) {
				done = true;
			}
			else {
				result += temp;
			}
		}

		return result;
	}

	public static int BFS() {
		Queue<Integer> que_x = new LinkedList<>();
		Queue<Integer> que_y = new LinkedList<>();

		int[][] visited = new int[arr.length][arr.length];

		int[] x_arr = {0, -1, 0, 1};
		int[] y_arr = {-1, 0, 1, 0};

		que_x.add(pos_x);
		que_y.add(pos_y);

		int temp_x, temp_y, curr_x, curr_y;

		int min_x = -1;
		int min_y = -1;
		int dist = Integer.MAX_VALUE;



		while(!que_x.isEmpty()) {
			curr_x = que_x.poll();
			curr_y = que_y.poll();

			for(int i = 0; i<4; i++) {

				temp_x = curr_x + x_arr[i];
				temp_y = curr_y + y_arr[i];


				if(check(temp_x, temp_y) && visited[temp_x][temp_y] == 0) {

					if(arr[temp_x][temp_y]==0 || arr[temp_x][temp_y] == bShark) {
						visited[temp_x][temp_y] = visited[curr_x][curr_y]+1;

						que_x.add(temp_x);
						que_y.add(temp_y);
					}
					else if(arr[temp_x][temp_y] < bShark) {

						visited[temp_x][temp_y] = visited[curr_x][curr_y]+1;

						que_x.add(temp_x);
						que_y.add(temp_y);

						if(dist > visited[temp_x][temp_y]) {
							min_x = temp_x;
							min_y = temp_y;
							dist = visited[temp_x][temp_y];
						}
						else if(dist == visited[temp_x][temp_y]) {

							if(min_x == temp_x) {
								if(min_y > temp_y) {
									min_x = temp_x;
									min_y = temp_y;
								}
							}
							else if(min_x > temp_x) {
								min_x = temp_x;
								min_y = temp_y;
							}

						}

					}

				}

			}
		}

		if(min_x != -1) {
			arr[min_x][min_y] = 0;
			cnt++;

			pos_x = min_x;
			pos_y = min_y;

			if(cnt==bShark) {
				cnt = 0;
				bShark++;
			}
		}

		return dist;
	}

	private static boolean check(int i, int j) {

		if(i >= 0 && arr.length > i && j>=0 && arr.length > j)
			return true;
		else
			return false;

	}

}
