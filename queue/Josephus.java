package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {

	// 11866�� 2020.12.22.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// ��� ��
		int m = Integer.parseInt(st.nextToken());	// �� ��° ������� �� ����

		Queue<Integer> que = new LinkedList<>();	// ���� ���� arr
		int[] result = new int[n];
		
		int index = 0;

		for(int i = 1; i<=n; i++)	// �ϴ� ��� ���� �־�����!
			que.add(i);
		
		int temp = 0;
		while(!que.isEmpty()) {
			for(int i = 0; i<m-1; i++) {
				temp = que.poll();
				que.add(temp);
			}
			
			result[index++] = que.poll();
			
		}
		
		bw.write("<");
		for(int i = 0; i<n; i++) {
			bw.write(result[i]+"");
			if(i!=n-1)
				bw.write(", ");
		}
		bw.write(">");
		bw.flush();
		bw.close();
		
	}

}
