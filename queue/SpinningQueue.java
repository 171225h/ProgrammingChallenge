package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SpinningQueue {

	// 1021��	2020.12.28.
	/* �ȿ� ���� ���� ��ġ�� �˻��ϸ� �ȵɰŰ��Ƽ� ��ο������ߴµ�
	*  �ٸ������ Ǯ�̸� ���� �ٵ� ����ߴ��� ����..
	*/
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// ť ũ��
		int m = Integer.parseInt(st.nextToken());	// �̾Ƴ����� �ϴ� ������ ��ġ
		int index = 0;		// arr index
		int temp = 0;		// ���° ���Ҹ� ���� ��
		int dqTemp = 0; 	// dq���� ���� ���� �ӽ� ����
		int result = 0;		// ��� �������� ��

		Deque<Integer> dq = new LinkedList<>();
		int[] arr = new int[m];

		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=n; i++)
			dq.add(i);
		
		for(int i = 0; i<m; i++) 
			arr[i]=Integer.parseInt(st.nextToken());
		
		
		while(index<m) {
			temp = arr[index];
			
			Iterator<Integer> iter = dq.iterator();
			int ind = 0;
			
			while(iter.hasNext()) {
				if(iter.next()==temp)
					break;
				ind++;
			}
			
			if(ind <= dq.size()/2) {
			//if(Math.abs(temp-dq.getFirst())<Math.abs(temp-dq.getLast())) {
				while(temp!=dq.getFirst()) {
					dqTemp = dq.pollFirst();
					dq.addLast(dqTemp);
					result++;
				}
			}
			else {
				while(temp!=dq.getFirst()) {
					dqTemp = dq.pollLast();
					dq.addFirst(dqTemp);
					result++;
				}
			}
			
			index++;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}