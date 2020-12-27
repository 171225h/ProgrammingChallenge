package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrintQueue {

	// 1966번 2020.12.23.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		Queue<Print> que = null;

		StringTokenizer st = null;
		int n = 0;				// 들어오는 입력 수
		int m = 0;				// 우리가 궁금한 페이지
		int count = 0;			// 몇 번째로 인쇄 되었는지 알려줌
		Integer[] weightArr = null;	// 가중치를 내림차순으로 정렬할 arr

		for(int i = 0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			count=0;
			
			que = new LinkedList<>();
			weightArr = new Integer[n];

			st = new StringTokenizer(br.readLine());	// 가중치들

			int temp = 0;
			for(int j = 0; j<n; j++) {
				temp = Integer.parseInt(st.nextToken());
				que.add(new Print(j, temp));
				weightArr[j] = temp;
			}

			Arrays.sort(weightArr, Collections.reverseOrder());
			
			Print tempPrint = null;
			while(!que.isEmpty() && count<n) {
				if(weightArr[count]>que.peek().getWeight()) {
					tempPrint = que.poll();
					que.add(tempPrint);
				}
				else {
					if(que.peek().getValue()==m) {
						bw.write((count+1)+"\n");
						break;
					}
					else {
						que.poll();
						count++;
					}
				}
			}
		}

		bw.flush();
		bw.close();
	}

}

class Print implements Comparable<Print> {

	int value;
	int weight;

	public Print(int v, int w) {
		value = v;
		weight = w;
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Print o) {
		if(o.weight > weight)
			return -1;
		else if(o.weight < weight)
			return 1;
		else
			return 0;
	}


}
