package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	
	// 1697�� 2021.07.27.
	
	/*
	 * ���ж����Ϳ��� ��Ǭ ������ ���� Ǯ����
	 * BFS�� ����ϸ� Ǯ���ٴ� ���� ���� �� ���̴�!!
	 * ���� �����̴� �� �ڽ��� �ڶ�������
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int finder = Integer.parseInt(st.nextToken());
		int hider = Integer.parseInt(st.nextToken());

		int result = BFS(finder, hider);
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	private static int BFS(int finder, int hider) {
		Queue<Integer> que = new LinkedList<>();

		que.add(finder);

		int temp = 0;
		boolean[] check = new boolean[100001];
		int[] count = new int[100001];
		
		count[finder]=0;

		while(!que.isEmpty() && finder!=hider) {
			
			finder = que.poll();
			check[finder] = true;

			temp = finder*2;
			if(boundaryCheck(temp) && !check[temp]) {
				que.add(temp);
				
				if(count[temp]==0) {
					count[temp] = count[finder]+1;
				}
				else {
					count[temp] = Math.min(count[temp], count[finder]+1);
				}
			}
			
			temp = finder+1;
			if(boundaryCheck(temp) && !check[temp]) {
				que.add(temp);
				
				if(count[temp]==0) {
					count[temp] = count[finder]+1;
				}
				else {
					count[temp] = Math.min(count[temp], count[finder]+1);
				}
			}
			
			temp = finder-1;
			if(boundaryCheck(temp) && !check[temp]) {
				que.add(temp);
				
				if(count[temp]==0) {
					count[temp] = count[finder]+1;
				}
				else {
					count[temp] = Math.min(count[temp], count[finder]+1);
				}
			}

		}


		return count[hider];
	}

	private static boolean boundaryCheck(int temp) {
		if(temp>-1 && temp<100001)
			return true;
		else
			return false;
	}

}
