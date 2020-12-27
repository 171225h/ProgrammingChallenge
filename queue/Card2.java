package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {

	// 2164¹ø, 2020.12.22.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1; i<=n; i++) {
			que.add(i);
		}
		
		
		
		while(que.size()!=1) {
			que.poll();
			if(que.size()==1)
				break;
			
			temp = que.poll();
			que.add(temp);
		}
		
		bw.write(que.poll()+"\n");
		bw.flush();
		bw.close();
	}

}
