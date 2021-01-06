package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {

	// 17298��	2021.01.06.
	/*
	 * �ð��ʰ������� �ָ��� �����̴٤�
	 * ū ������ ������ temp��� stack�� ������ְ� �ű⿡ ������ �־��ش�!
	 * ���� 46�ٺ��Ͱ� �ٽ�. ó���� result�� temp�� ���������� �׷� �ʿ䰡 ����.
	 * ���� ������ ���� ���� temp�� �־�� �ʿ䵵 ���� �ֳĸ� �����ʿ� ū �� �� ���� ���� ���ʿ� ����� ���� ���ϴ� ���̱� ������
	 * �� ��������!
	 * ó���� result�� ���������� �׷��� ������� ������ �ϴ� ���̱� ������ ���� �׷� �ʿ� ����.
	 * �������� �� ������ Ǭ ���� ������ �ʹ��ʹ� ��ڴ�
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();	// input
		Stack<Integer> result = new Stack<>();	// result
		Stack<Integer> temp = new Stack<>();;	// ū �� ���� ���� stack

		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			stack.add(Integer.parseInt(st.nextToken()));

		// NGE �ٽ�
		for(int i = 0; i<n; i++) {
			if(result.isEmpty()) {	// ��������� -1
				result.add(-1);
			}
			else {					
				if(temp.isEmpty())	// temp���� �����ص� ���� ���ٸ� -1
					result.add(-1);
				else if(temp.peek()>stack.peek()) {	// temp�� ���� stack.peek���� ũ�� result�� �־��ֱ�
					result.add(temp.peek());
				}
				else {
					while(!temp.isEmpty() && temp.peek()<=stack.peek()) // ������ �ٽ�! temp�� ��ų�, Ŭ������ temp.pop
						temp.pop();
					
					if(temp.isEmpty())
						result.add(-1);
					else
						result.add(temp.peek());
				}
			}
			temp.add(stack.pop());
		}

		while(result.size()>1)
			bw.write(result.pop()+" ");
		bw.write(result.pop()+"");

		bw.flush();
		bw.close();
	}

}
