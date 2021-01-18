package priorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsoluteValueHeap implements Comparator<Integer>{

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
		PriorityQueue<Integer> que = new PriorityQueue<>(new AbsoluteValueHeap());

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

	@Override
	public int compare(Integer o1, Integer o2) {
		if(Math.abs(o1) < Math.abs(o2))
			return -1;
		else if(Math.abs(o1) > Math.abs(o2))
			return 1;
		else if(o1 < o2)
			return -1;
		else if(o1 > o2)
			return 1;
		else
			return 0;
	}

}
