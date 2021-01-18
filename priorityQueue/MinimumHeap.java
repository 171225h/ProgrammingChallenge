package priorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MinimumHeap {

	// 1927번 	2021.01.18.
	/*
	 * priority Queue를 사용하면 가볍게 완료!
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>();

		for(int i = 0; i<n; i++) {
			temp = Integer.parseInt(br.readLine());

			if(temp==0) {
				if(que.isEmpty())
					bw.write(0+"\n");
				else
					bw.write(que.poll()+"\n");
			}
			else
				que.add(temp);
		}

		bw.flush();
		bw.close();
	}

}
