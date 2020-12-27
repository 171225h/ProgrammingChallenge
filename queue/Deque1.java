package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Deque1 {

	//10866번 2020.12.24.
	//front는 채워진쪽에서 하나 더 크게, rear는 채워진 마지막을 가리키게 하기
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		Deque dq = new Deque();

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();

			if(temp.equals("push_front"))
				dq.push_front(Integer.parseInt(st.nextToken()));
			else if(temp.equals("push_back"))
				dq.push_back(Integer.parseInt(st.nextToken()));
			else if(temp.equals("pop_front"))
				bw.write(dq.pop_front()+"\n");
			else if(temp.equals("pop_back"))
				bw.write(dq.pop_back()+"\n");
			else if(temp.equals("size"))
				bw.write(dq.size()+"\n");
			else if(temp.equals("empty"))
				bw.write(dq.empty()+"\n");
			else if(temp.equals("front"))
				bw.write(dq.front()+"\n");
			else if(temp.equals("back"))
				bw.write(dq.back()+"\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
class Deque{
	int front;
	int rear;
	private int[] arr;

	public Deque() {
		front = 5000;
		rear = 5000;
		arr = new int[10000];
	}

	public void push_front(int n) {
		arr[front]=n;
		front--;
	}

	public void push_back(int n) {
		rear++;
		arr[rear]=n;
	}

	public int pop_front() {
		if(size()==0)
			return -1;

		front++;
		return arr[front];
	}

	public int pop_back() {
		if(size()==0)
			return -1;

		rear--;
		return arr[rear+1];
	}

	public int size() {
		return rear-front;
	}

	public int empty() {
		return size()==0 ? 1 : 0;
	}
	public int front() {
		if(size()<=0)
			return -1;

		return arr[front+1];
	}
	public int back() {
		if(size()<=0)
			return -1;

		return arr[rear];
	}
}
