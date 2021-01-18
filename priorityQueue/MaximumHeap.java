package priorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumHeap {

	// 11279번 	2021.01.18.
	/*
	 * priority Queue를 사용하고
	 * Collections.reverseOrder를 사용하면 성공!
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		
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
