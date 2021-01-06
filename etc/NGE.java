package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {

	// 17298번	2021.01.06.
	/*
	 * 시간초과때문에 애먹은 문제이다ㅜ
	 * 큰 수들을 저장할 temp라는 stack을 만들어주고 거기에 값들을 넣어준다!
	 * 만약 46줄부터가 핵심. 처음엔 result를 temp에 복제했지만 그럴 필요가 없다.
	 * 현재 값보다 작은 값은 temp에 넣어둘 필요도 없다 왜냐면 오른쪽에 큰 수 중 수중 가장 왼쪽에 가까운 수를 택하는 것이기 때문에
	 * 다 빼버린다!
	 * 처음엔 result를 복제했지만 그러면 쓸모없는 연산을 하는 것이기 때문에 굳이 그럴 필요 없다.
	 * 오랜만에 내 힘으로 푼 금장 문제라 너무너무 기쁘다
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();	// input
		Stack<Integer> result = new Stack<>();	// result
		Stack<Integer> temp = new Stack<>();;	// 큰 수 들을 넣을 stack

		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			stack.add(Integer.parseInt(st.nextToken()));

		// NGE 핵심
		for(int i = 0; i<n; i++) {
			if(result.isEmpty()) {	// 비어있으면 -1
				result.add(-1);
			}
			else {					
				if(temp.isEmpty())	// temp에도 저장해둔 수가 없다면 -1
					result.add(-1);
				else if(temp.peek()>stack.peek()) {	// temp에 수가 stack.peek보다 크면 result에 넣어주기
					result.add(temp.peek());
				}
				else {
					while(!temp.isEmpty() && temp.peek()<=stack.peek()) // 이쪽이 핵심! temp가 비거나, 클때까지 temp.pop
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
