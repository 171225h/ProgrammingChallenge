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

	// 1021번	2020.12.28.
	/* 안에 원소 값의 위치를 검색하면 안될거같아서 고민열심히했는데
	*  다른사람들 풀이를 보니 다들 계산했더라 ㅎㅎ..
	*/
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// 큐 크기
		int m = Integer.parseInt(st.nextToken());	// 뽑아내려고 하는 원소의 위치
		int index = 0;		// arr index
		int temp = 0;		// 몇번째 원소를 뽑을 지
		int dqTemp = 0; 	// dq에서 뽑은 값을 임시 저장
		int result = 0;		// 몇번 움직였는 지

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