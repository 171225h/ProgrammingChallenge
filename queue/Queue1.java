package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Queue1 {

	// 18258¹ø. 2020 12 22
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		Queue que = new Queue(n);

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if(temp.equals("push")) {
				que.push(Integer.parseInt(st.nextToken()));
			}
			else if(temp.equals("pop")) {
				bw.write(que.pop()+"\n");
			}
			else if(temp.equals("size")) {
				bw.write(que.size()+"\n");
			}
			else if(temp.equals("empty")) {
				bw.write(que.empty()+"\n");
			}
			else if(temp.equals("front")) {
				bw.write(que.front()+"\n");
			}
			else if(temp.equals("back")) {
				bw.write(que.back()+"\n");
			}
		}

		bw.flush();
		bw.close();
	}

}

class Queue{

	private int[] array;
	private int head;
	private int rear;

	public Queue(int n) {
		array = new int[n];

		head = -1;
		rear = -1;
	}

	public void push(int n) {
			rear++;
			array[rear]=n;
	}

	public int pop() {
		if(rear<=head) {
			return -1;
		}
		else {
			head++;
			return array[head];
		}
	}
	public int size() {
		return rear-head;
	}
	public int empty() {
		if(rear-head<=0)
			return 1;
		else
			return 0;
	}
	public int front() {
		if(rear-head<=0)
			return -1;
		else
			return array[head+1];
	}
	public int back() {
		if(rear-head<=0)
			return -1;
		else
			return array[rear];
	}
}