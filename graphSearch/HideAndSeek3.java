package graphSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

	/*
	 * fail
	 * 13549
	 * 
	 * ���ݱ����� ����ġ�� ������ ������ ���� BFS�� ����������
	 * �� ������ ���� ����ġ�� �ٸ��� ������
	 * �Ϲ����� Queue�� �̿��� BFS�� ����ϸ� �ȵǴ� ���� ���
	 * Deque�� �̿��ؼ� Ǯ �� �ִ� ����! �� PriorityQueue�� �̿밡���ϴٰ� ��
	 * 
	 * �� �����̵� ������ ���� �����ؾ��ϴµ� �� ������ �湮üũ����~
	 * https://www.acmicpc.net/board/view/74814
	 */

public class HideAndSeek3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int result = BFS(n, m);

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	private static int BFS(int n, int m) {

		Deque<Integer> que = new LinkedList<>();

		int[] visited = new int[100001];
		for(int i = 0; i<=100000; i++)
			visited[i] = -1;

		que.add(n);
		visited[n] = 0;

		int cur, temp;

		while(!que.isEmpty()) {

			cur = que.poll();

			temp = cur*2;
			if(checkRange(temp) && visited[temp]==-1) {
				que.addFirst(temp);
				visited[temp] = visited[cur];
			}

			temp = cur + 1;
			if(checkRange(temp) && visited[temp]==-1) {
				que.addLast(temp);
				visited[temp] = visited[cur]+1;
			}

			temp = cur - 1;
			if(checkRange(temp) && visited[temp]==-1) {
				que.addLast(temp);
				visited[temp] = visited[cur]+1;
			}

		}

		return visited[m];
	}

	private static boolean checkRange(int temp) {
		if(temp >= 0 && temp <= 100000)
			return true;
		else
			return false;
	}

}
