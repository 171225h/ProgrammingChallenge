package priorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MedianHeap{

	// 11286번 	2021.01.18.
	/*
	 * priority Queue를 사용하면 가볍게 완료!
	 * 새로 Comparator만 정의해주자
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>();

		Object[] tempArr = null;
		int median = 0;

		for(int i = 0; i<n; i++) {
			temp = Integer.parseInt(br.readLine());
			
			que.add(temp);
			
			if(que.size()==1) {
				bw.write(temp+"\n");	
				continue;
			}
			
			tempArr = que.toArray();
			median = (int)tempArr[que.size()/2]<(int)tempArr[que.size()/2+1] ? (int)tempArr[que.size()/2] : (int)tempArr[que.size()/2+1];
			bw.write(median+"\n");
		}

		bw.flush();
		bw.close();
	}
}
